package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.Artifact;

import java.util.List;

import static io.intino.confloader.Safe.safe;
import static io.intino.confloader.Safe.safeList;
import static java.util.stream.Collectors.toList;

public class WrapperArtifact implements Configuration.Artifact {
	private final Artifact artifact;

	public WrapperArtifact(Artifact artifact) {

		this.artifact = artifact;
	}

	@Override
	public String groupId() {
		return artifact.groupId();
	}

	@Override
	public String name() {
		return artifact.name$();
	}

	@Override
	public void name(String s) {

	}

	@Override
	public String version() {
		return artifact.version();
	}

	@Override
	public String description() {
		return null;
	}

	@Override
	public String url() {
		return null;
	}

	@Override
	public void version(String s) {

	}

	@Override
	public Configuration.Artifact.Code code() {
		return null;
	}

	@Override
	public Configuration.Artifact.Model model() {
		return null;
	}

	@Override
	public Configuration.Artifact.Box box() {
		return new WrapperBox(artifact);
	}

	@Override
	public Configuration.Artifact.Dependency.DataHub datahub() {
		return artifact.dataHub() == null ? null : new WrapperDatahub(artifact);
	}

	@Override
	public Configuration.Artifact.Dependency.Archetype archetype() {
		return null;
	}

	@Override
	public List<Configuration.Artifact.Dependency> dependencies() {
		return safeList(()->artifact.imports().dependencyList().stream().map(WrapperDependency::new).collect(toList()));
	}

	@Override
	public List<Configuration.Artifact.WebComponent> webComponents() {
		return safeList(() -> artifact.webImports().webComponentList().stream().map(WrapperWebComponent::new).collect(toList()));
	}

	@Override
	public List<Configuration.Artifact.WebResolution> webResolutions() {
		return safeList(() -> artifact.webImports().resolutionList().stream().map(WrapperResolution::new).collect(toList()));
	}

	@Override
	public List<Configuration.Artifact.WebArtifact> webArtifacts() {
		return safeList(() -> artifact.webImports().webArtifactList().stream().map(WrapperWebArtifact::new).collect(toList()));
	}

	@Override
	public List<Configuration.Artifact.Plugin> plugins() {
		return null;
	}

	@Override
	public Configuration.Artifact.License license() {
		return null;
	}

	@Override
	public Configuration.Artifact.Scm scm() {
		return null;
	}

	@Override
	public List<Configuration.Artifact.Developer> developers() {
		return artifact.developerList().stream().map(d -> new Configuration.Artifact.Developer() {
			@Override
			public String name() {
				return d.name();
			}

			@Override
			public String email() {
				return d.email();
			}

			@Override
			public String organization() {
				return d.organization();
			}

			@Override
			public String organizationUrl() {
				return d.organizationUrl();
			}
		}).collect(toList());
	}

	@Override
	public Configuration.Artifact.QualityAnalytics qualityAnalytics() {
		return null;
	}

	@Override
	public List<Configuration.Parameter> parameters() {
		return artifact.parameterList().stream().map(p -> new Configuration.Parameter() {
			@Override
			public String name() {
				return p.name();
			}

			@Override
			public String value() {
				return p.defaultValue();
			}

			@Override
			public String description() {
				return null;
			}

			@Override
			public Configuration root() {
				return null;
			}

			@Override
			public Configuration.ConfigurationNode owner() {
				return null;
			}
		}).collect(toList());
	}

	@Override
	public Configuration.Artifact.Package packageConfiguration() {
		return new Configuration.Artifact.Package() {
			@Override
			public LinuxService linuxService() {
				return null;
			}

			@Override
			public Mode mode() {
				return Mode.ModulesAndLibrariesLinkedByManifest;
			}

			@Override
			public boolean isRunnable() {
				return artifact.package$().isRunnable();
			}

			@Override
			public boolean createMavenPom() {
				return false;
			}

			@Override
			public boolean attachSources() {
				return artifact.package$().attachSources();
			}

			@Override
			public List<String> mavenPlugins() {
				return artifact.package$().mavenPluginList().stream().map(Artifact.Package.MavenPlugin::code).collect(toList());
			}

			@Override
			public boolean attachDoc() {
				return artifact.package$().attachDoc();
			}

			@Override
			public boolean includeTests() {
				return false;
			}

			@Override
			public boolean signArtifactWithGpg() {
				return false;
			}

			@Override
			public String classpathPrefix() {
				return null;
			}

			@Override
			public String finalName() {
				return artifact.package$().finalName();
			}

			@Override
			public String defaultJVMOptions() {
				return null;
			}

			@Override
			public String mainClass() {
				return safe(() -> artifact.package$().asRunnable().mainClass());
			}

			@Override
			public MacOs macOsConfiguration() {
				return null;
			}

			@Override
			public Windows windowsConfiguration() {
				return null;
			}
		};
	}

	@Override
	public List<Configuration.Deployment> deployments() {
		return artifact.deploymentList().stream().map(d -> new WrapperDeployment(d,new WrapperArtifact(artifact))).collect(toList());
	}

	@Override
	public Configuration.Distribution distribution() {
		return new Configuration.Distribution() {
			@Override
			public Configuration.Repository release() {
				List<Artifact.Distribution.Artifactory> artifactories = artifact.distribution().artifactoryList();
				return artifactories.isEmpty() ? null : repository(artifactories.get(0), false);
			}

			@Override
			public Configuration.Repository snapshot() {
				List<Artifact.Distribution.Artifactory> artifactories = artifact.distribution().artifactoryList();
				return artifactories.isEmpty() || artifactories.get(0).snapshot() == null ? null : repository(artifactories.get(0), true);
			}

			@Override
			public BitBucketDistribution onBitbucket() {
				return null;
			}

			@Override
			public boolean distributeLanguage() {
				return false;
			}
		};
	}

	@Override
	public Configuration root() {
		return null;
	}

	@Override
	public Configuration.ConfigurationNode owner() {
		return null;
	}

	private static Configuration.Repository repository(Artifact.Distribution.Artifactory artifactory, boolean snapshot) {
		return new Configuration.Repository() {
			@Override
			public String identifier() {
				return artifactory.identifier();
			}

			@Override
			public String url() {
				return snapshot ? artifactory.snapshot().url() : artifactory.release().url();
			}

			@Override
			public String user() {
				return null;
			}

			@Override
			public String password() {
				return null;
			}

			@Override
			public UpdatePolicy updatePolicy() {
				return UpdatePolicy.Always;
			}

			@Override
			public Configuration root() {
				return null;
			}

			@Override
			public Configuration.ConfigurationNode owner() {
				return null;
			}
		};
	}

}
