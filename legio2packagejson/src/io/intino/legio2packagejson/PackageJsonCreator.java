package io.intino.legio2packagejson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.intino.Configuration;
import io.intino.Configuration.Artifact;
import io.intino.alexandria.logger.Logger;
import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PackageJsonCreator {
	private final Artifact artifact;
	private final List<Artifact.WebComponent> webComponents;
	private final List<Artifact.WebResolution> resolutions;
	private final WebArtifactResolver webArtifactResolver;
	private Map<String, Map.Entry<String, String>> credentials;

	public PackageJsonCreator(Configuration conf, File credentialsFile, File destination) {
		this.artifact = conf.artifact();
		this.webComponents = artifact.webComponents();
		this.resolutions = artifact.webResolutions();
		loadCredentials(credentialsFile);
		this.webArtifactResolver = new WebArtifactResolver(artifact, conf.repositories(), credentials, destination);
	}

	public void createPackageFile(File rootDirectory) {
		write(new Package_jsonTemplate().render(packageFrame().toFrame()), new File(rootDirectory, "package.json"));
	}

	public void extractArtifacts() {
		if (SystemUtils.IS_OS_WINDOWS) webArtifactResolver.extractArtifacts();
	}

	private FrameBuilder packageFrame() {
		List<JsonObject> packages = webArtifactResolver.resolveArtifacts();
		FrameBuilder builder = baseFrame().add("package");
		if (SystemUtils.IS_OS_MAC_OSX) builder.add("fsevents", "");
		Map<String, String> dependencies = collectDependencies(packages);
		dependencies.forEach((key, value) -> builder.add("dependency", new FrameBuilder().add("name", key).add("version", value)));
		resolutions.forEach(resolution -> builder.add("resolution", resolutionFrameFrom(resolution)));
		packages.stream().map(this::resolutionFrameFrom).filter(Objects::nonNull).forEach(frames -> builder.add("resolution", frames));
		return builder;
	}

	private Map<String, String> collectDependencies(List<JsonObject> packages) {
		Map<String, String> dependencies = new LinkedHashMap<>();
		webComponents.forEach(c -> dependencies.putIfAbsent(c.name(), c.version()));
		packages.forEach(p -> dependenciesFrom(p).forEach(dependencies::putIfAbsent));
		return dependencies;
	}

	private FrameBuilder baseFrame() {
		return new FrameBuilder().add("groupId", artifact.groupId()).add("artifactId", artifact.name()).add("version", artifact.version());
	}

	private Frame[] resolutionFrameFrom(JsonObject object) {
		List<Frame> frames = new ArrayList<>();
		if (object.get("resolutions") == null) return null;
		final JsonObject dependencies = object.get("resolutions").getAsJsonObject();
		for (Map.Entry<String, JsonElement> entry : dependencies.entrySet())
			frames.add(new FrameBuilder().add("name", entry.getKey()).add("version", entry.getValue().toString().replaceAll("\"", "")).toFrame());
		return frames.toArray(new Frame[0]);
	}

	private Frame resolutionFrameFrom(Artifact.WebResolution resolution) {
		return new FrameBuilder().add("name", resolution.name()).add("version", resolution.version()).toFrame();
	}


	private Map<String, String> dependenciesFrom(JsonObject object) {
		Map<String, String> map = new HashMap<>();
		if (object.get("dependencies") == null) return map;
		final JsonObject dependencies = object.get("dependencies").getAsJsonObject();
		for (Map.Entry<String, JsonElement> entry : dependencies.entrySet())
			map.put(entry.getKey(), entry.getValue().getAsString());
		return map;
	}

	private void write(String content, File destiny) {
		try {
			Files.writeString(destiny.toPath(), content);
		} catch (IOException e) {
			Logger.error(e.getMessage(), e);
		}
	}

	private void loadCredentials(File credentialsFile) {
		try (Stream<String> lines = Files.lines(credentialsFile.toPath())) {
			this.credentials = lines.map(l -> l.split("\t")).collect(Collectors.toMap(f -> f[0], f -> new AbstractMap.SimpleEntry<>(f[1], f[2])));
		} catch (IOException e) {
			Logger.error(e);
			credentials = new HashMap<>();
		}
	}

}
