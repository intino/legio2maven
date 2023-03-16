package io.intino.legio2maven.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.LegioGraph;

import java.util.List;

import static io.intino.legio2maven.Safe.safe;
import static java.util.stream.Collectors.toList;

public class WrapperConfiguration implements Configuration {

	private final LegioGraph graph;

	public WrapperConfiguration(LegioGraph graph) {
		this.graph = graph;
	}

	@Override
	public Artifact artifact() {
		return new Artifact() {
			@Override
			public String groupId() {
				return graph.artifact().groupId();
			}

			@Override
			public String name() {
				return graph.artifact().name$();
			}

			@Override
			public void name(String s) {

			}

			@Override
			public String version() {
				return graph.artifact().version();
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
			public Code code() {
				return null;
			}

			@Override
			public Model model() {
				return null;
			}

			@Override
			public Box box() {
				return new WrapperBox(graph);
			}

			@Override
			public Dependency.DataHub datahub() {
				return graph.artifact().dataHub() == null ? null : new WrapperDatahub(graph);
			}

			@Override
			public Dependency.Archetype archetype() {
				return null;
			}

			@Override
			public List<Dependency> dependencies() {
				return graph.artifact().imports().dependencyList().stream()
						.map(d -> new WrapperDependency(d)).collect(toList());
			}

			@Override
			public List<WebComponent> webComponents() {
				return null;
			}

			@Override
			public List<WebResolution> webResolutions() {
				return null;
			}

			@Override
			public List<WebArtifact> webArtifacts() {
				return null;
			}

			@Override
			public List<Plugin> plugins() {
				return null;
			}

			@Override
			public License license() {
				return null;
			}

			@Override
			public Scm scm() {
				return null;
			}

			@Override
			public List<Developer> developers() {
				return graph.artifact().developerList().stream().map(d -> new Developer() {
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
			public QualityAnalytics qualityAnalytics() {
				return null;
			}

			@Override
			public List<Parameter> parameters() {
				return graph.artifact().parameterList().stream().map(p -> new Parameter() {
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
					public ConfigurationNode owner() {
						return null;
					}
				}).collect(toList());
			}

			@Override
			public Package packageConfiguration() {
				return new Package() {
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
						return graph.artifact().package$().isRunnable();
					}

					@Override
					public boolean createMavenPom() {
						return false;
					}

					@Override
					public boolean attachSources() {
						return graph.artifact().package$().attachSources();
					}

					@Override
					public List<String> mavenPlugins() {
						return graph.artifact().package$().mavenPluginList().stream().map(m -> m.code()).collect(toList());
					}

					@Override
					public boolean attachDoc() {
						return graph.artifact().package$().attachDoc();
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
						return graph.artifact().package$().finalName();
					}

					@Override
					public String defaultJVMOptions() {
						return null;
					}

					@Override
					public String mainClass() {
						return safe(() -> graph.artifact().package$().asRunnable().mainClass());
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
			public Distribution distribution() {
				return new Distribution() {
					@Override
					public Repository release() {
						List<io.intino.legio.model.Artifact.Distribution.Artifactory> artifactories = graph.artifact().distribution().artifactoryList();
						return new Repository() {
							@Override
							public String identifier() {
								return artifactories.isEmpty() ? null : artifactories.get(0).identifier();
							}

							@Override
							public String url() {
								return artifactories.isEmpty() ? null : artifactories.get(0).release().url();
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
							public Configuration root() {
								return null;
							}

							@Override
							public ConfigurationNode owner() {
								return null;
							}
						};
					}

					@Override
					public Repository snapshot() {
						return null;
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
			public ConfigurationNode owner() {
				return null;
			}
		};
	}

	@Override
	public List<Server> servers() {
		return null;
	}

	@Override
	public List<RunConfiguration> runConfigurations() {
		return null;
	}

	@Override
	public List<Repository> repositories() {
		return graph.repositoryList().stream().map(WrapperRepository::new).collect(toList());
	}
}
