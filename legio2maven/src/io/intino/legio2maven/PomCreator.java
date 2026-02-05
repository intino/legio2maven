package io.intino.legio2maven;

import io.intino.Configuration;
import io.intino.Configuration.Artifact;
import io.intino.Configuration.Artifact.Dependency;
import io.intino.Configuration.Artifact.Package.Mode;
import io.intino.Configuration.Repository;
import io.intino.alexandria.logger.Logger;
import io.intino.itrules.Engine;
import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.template.Template;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static io.intino.Configuration.Artifact.Package.Mode.LibrariesLinkedByManifest;
import static io.intino.Configuration.Artifact.Package.Mode.ModulesAndLibrariesLinkedByManifest;
import static io.intino.confloader.Safe.safe;
import static io.intino.confloader.Safe.safeList;
import static java.io.File.separator;


public class PomCreator {
	private final Configuration configuration;
	private final Mode packageType;
	private final File rootDirectory;

	public PomCreator(Configuration configuration, File rootDirectory) {
		this.configuration = configuration;
		this.packageType = safe(() -> configuration.artifact().packageConfiguration()) == null ? null : configuration.artifact().packageConfiguration().mode();
		this.rootDirectory = rootDirectory;
	}

	public void create(File pom) {
		Artifact.Package build = safe(() -> configuration.artifact().packageConfiguration());
		FrameBuilder builder = new FrameBuilder();
		fillMavenId(builder);
//		final String[] languageLevel = {"11"};
//		builder.add("sdk", languageLevel[0]);
		fillFramework(build, builder);
		writePom(pom, builder.toFrame(), new PomTemplate());
	}

	private Version version() throws Exception {
		return new Version(configuration.artifact().version());
	}


	private void fillMavenId(FrameBuilder builder) {
		Artifact artifact = configuration.artifact();
		builder.add("pom").add("groupId", artifact.groupId()).add("artifactId", artifact.name()).add("version", artifact.version());
	}

	private void fillFramework(Artifact.Package pack, FrameBuilder builder) {
		fillDirectories(builder);
		builder.add("outDirectory", relativeToModulePath(new File(projectOutDirectory(), "production").getAbsolutePath()));
		builder.add("testOutDirectory", relativeToModulePath(new File(projectOutDirectory(), "test").getAbsolutePath()));
		builder.add("buildDirectory", relativeToModulePath(buildDirectory()) + "/");
		if (pack != null) configureBuild(builder, configuration.artifact(), pack);
		addPlugins(builder);
		addDependencies(builder);
		addRepositories(builder);
	}

	private void addPlugins(FrameBuilder builder) {
		configuration.artifact().packageConfiguration().mavenPlugins().forEach(mp -> builder.add("mavenPlugin", mp));
	}

	private String buildDirectory() {
		return projectOutDirectory() + separator + "build" + separator;
	}

	private String projectOutDirectory() {
		return rootDirectory + separator + "out";
	}

	private String relativeToModulePath(String path) {
		Path other = Paths.get(path);
		Path modulePath = moduleDirectory().toPath();
		try {
			return modulePath.relativize(other.toAbsolutePath()).toFile().getPath();
		} catch (IllegalArgumentException e) {
			return path;
		}
	}

	private File moduleDirectory() {
		return rootDirectory;
	}

	private void addDependencies(FrameBuilder builder) {
		builder.add("compile", " ");
		Set<String> dependencies = new HashSet<>();
		List<Dependency> moduleDependencies = collectDependencies();
		for (Dependency dependency : moduleDependencies.stream().filter(d -> !d.scope().equalsIgnoreCase("test")).toList())
			if (dependencies.add(dependency.identifier()))
				builder.add("dependency", createDependencyFrame(dependency));
		for (Dependency dependency : moduleDependencies.stream().filter(d -> d.scope().equalsIgnoreCase("test")).toList())
			if ((!dependency.toModule() || (dependency.toModule() && allModulesSeparated())) && dependencies.add(dependency.identifier()))
				builder.add("dependency", createDependencyFrame(dependency));

	}

	private boolean allModulesSeparated() {
		return packageType.equals(ModulesAndLibrariesLinkedByManifest);
	}

	private List<Dependency> collectDependencies() {
		List<Dependency> deps = new ArrayList<>(safeList(() -> configuration.artifact().dependencies())).stream().filter(d -> !(d instanceof Dependency.Web)).collect(Collectors.toList());
		Dependency datahub = configuration.artifact().datahub();
		if (datahub != null) deps.addFirst(datahub);
		Dependency archetype = configuration.artifact().archetype();
		if (archetype != null) deps.addFirst(archetype);
		return deps;
	}

	private void addRepositories(FrameBuilder builder) {
		configuration.repositories().forEach(r -> builder.add("repository", createRepositoryFrame(r)));
		Repository repository = distributionRepository();
		if (repository != null)
			builder.add("repository", createDistributionRepositoryFrame(repository, "release"));
	}

	private Repository distributionRepository() {
		try {
			Version version = version();
			if (version.isSnapshot()) return safe(() -> configuration.artifact().distribution().snapshot());
			return safe(() -> configuration.artifact().distribution().release());
		} catch (Exception e) {
			Logger.error(e);
			return null;
		}
	}

	private void fillDirectories(FrameBuilder builder) {
		builder.add("sourceDirectory", srcDirectories());
		builder.add("resourceDirectory", resourceDirectories());
	}

	private String[] srcDirectories() {
		return Arrays.stream(new String[]{"src", "gen"})
				.filter(s -> new File(rootDirectory, s).exists())
				.toArray(String[]::new);
	}

	private String[] resourceDirectories() {
		return Arrays.stream(new String[]{"res"})
				.filter(s -> new File(rootDirectory, s).exists())
				.toArray(String[]::new);
	}


	private void configureBuild(FrameBuilder builder, Artifact artifact, Artifact.Package aPackage) {
		if (artifact.url() != null) builder.add("url", artifact.url());
		if (artifact.description() != null) builder.add("description", artifact.description());
		if (aPackage.attachSources()) builder.add("attachSources", " ");
		if (aPackage.signArtifactWithGpg()) builder.add("gpgSign", " ");
		if (aPackage.attachDoc()) builder.add("attachJavaDoc", " ");
		if (aPackage.isRunnable()) {
			if (aPackage.macOsConfiguration() != null) builder.add("osx", osx(aPackage));
			if (aPackage.windowsConfiguration() != null) builder.add("windows", windows(aPackage));
		}
		final Mode type = aPackage.mode();
		if (type.equals(LibrariesLinkedByManifest) || type.equals(ModulesAndLibrariesLinkedByManifest)) {
			builder.add("linkLibraries", "true");
			FrameBuilder copyDependencies = new FrameBuilder("copyDependencies");
			builder.add("copyDependencies", copyDependencies.toFrame());
			if (aPackage.classpathPrefix() != null)
				copyDependencies.add("classpathPrefix", aPackage.classpathPrefix());
		} else builder.add("linkLibraries", "false").add("extractedLibraries", " ");
		if (aPackage.isRunnable()) builder.add("mainClass", aPackage.mainClass());
		configuration.artifact().parameters().forEach(parameter -> addParameter(builder, parameter));
		if (aPackage.defaultJVMOptions() != null && !aPackage.defaultJVMOptions().isEmpty())
			addMVOptions(builder, aPackage.defaultJVMOptions());
		if (aPackage.finalName() != null && !aPackage.finalName().isEmpty())
			builder.add("finalName", aPackage.finalName());
		builder.add("developer", artifact.developers().stream().map(d -> new FrameBuilder("developer").
				add("name", d.name()).
				add("email", d.email()).
				add("organization", d.organization()).
				add("organizationUrl", d.organizationUrl()).
				toFrame()).toArray(Frame[]::new));
		if (artifact.license() != null)
			builder.add("license", new FrameBuilder("license", artifact.license().type().name()).toFrame());
		if (artifact.license() != null) {
			Artifact.Scm scm = artifact.scm();
			builder.add("scm", new FrameBuilder("scm").add("url", scm.url()).
					add("connection", scm.connection()).
					add("developerConnection", scm.developerConnection()).
					add("tag", scm.tag()).toFrame());
		}

	}

	private void addMVOptions(FrameBuilder frame, String jvmOptions) {
		frame.add("vmOptions", jvmOptions);
	}

	private void addParameter(FrameBuilder frame, Configuration.Parameter parameter) {
		final FrameBuilder pFrame = new FrameBuilder("parameter").add("key", parameter.name());
		if (parameter.value() != null) pFrame.add("value", parameter.value());
		if (parameter.description() != null && !parameter.description().isEmpty())
			pFrame.add("description", parameter.description());
		frame.add("parameter", pFrame.toFrame());
	}

	private Frame osx(Artifact.Package build) {
		final FrameBuilder builder = new FrameBuilder().add("mainClass", build.mainClass());
		String icon = safe(() -> build.macOsConfiguration().icon());
		if (icon != null && !icon.isEmpty())
			builder.add("icon", icon);
		return builder.toFrame();
	}

	private Frame windows(Artifact.Package build) {
		final FrameBuilder builder = new FrameBuilder().add("mainClass", build.mainClass());
		builder.add("icon", build.windowsConfiguration().icon());
		final Artifact artifact = configuration.artifact();
		builder.add("name", artifact.name()).add("out", buildDirectory()).add("version", artifact.version());
		builder.add("prefix", build.classpathPrefix() != null ? build.classpathPrefix() : "dependency");
		return builder.toFrame();
	}


	private Frame createDependencyFrame(Dependency d) {
		final FrameBuilder builder = new FrameBuilder("dependency").add("groupId", d.groupId()).
				add("scope", d.scope()).
				add("artifactId", d.artifactId()).
				add("version", d.version());
		if (!d.excludes().isEmpty()) for (Dependency.Exclude exclude : d.excludes())
			builder.add("exclusion", new FrameBuilder("exclusion").add("groupId", exclude.groupId()).add("artifactId", exclude.artifactId()).toFrame());
		return builder.toFrame();
	}

	private Frame createDependencyFrame(String[] id) {
		return new FrameBuilder("dependency").add("groupId", id[0].toLowerCase()).add("scope", "compile").add("artifactId", id[1].toLowerCase()).add("version", id[2]).toFrame();
	}

	private Frame createRepositoryFrame(Repository repo) {
		return new FrameBuilder("repository", repo.getClass().getSimpleName()).
				add("name", repo.identifier()).
				add("url", repo.url()).
				add("type", (repo instanceof Repository.Snapshot) ? "-snapshot" : "").
				add("snapshot", repo instanceof Repository.Snapshot).toFrame();
	}

	private Frame createDistributionRepositoryFrame(Repository repo, String type) {
		return new FrameBuilder("repository", "distribution", type).
				add("url", repo.url()).
				add("name", repo.identifier()).
				add("type", "release").toFrame();
	}

	private void writePom(File pom, Frame frame, Template template) {
		try {
			Files.write(pom.toPath(), new Engine(template).render(frame).getBytes());
		} catch (IOException e) {
			Logger.error("Error creating pomFile to publish action: " + e.getMessage());
		}
	}
}
