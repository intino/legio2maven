package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.Artifact;
import io.intino.legio.model.RunConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WrapperDeployment implements Configuration.Deployment {
	private final Artifact.Deployment d;
	private final Configuration.Artifact artifact;

	public WrapperDeployment(Artifact.Deployment d, WrapperArtifact artifact) {
		this.d = d;
		this.artifact = artifact;
	}

	@Override
	public Configuration.Server server() {
		return new Configuration.Server() {
			@Override
			public String name() {
				return d.server().name$();
			}

			@Override
			public Type type() {
				return Type.valueOf(d.server().type().name());
			}
		};
	}


	@Override
	public Configuration.RunConfiguration runConfiguration() {
		RunConfiguration rc = d.runConfiguration();
		return new Configuration.RunConfiguration() {
			@Override
			public String name() {
				return rc.name$();
			}

			@Override
			public String mainClass() {
				return rc.mainClass();
			}

			@Override
			public String vmOptions() {
				return rc.vmOptions();
			}

			@Override
			public List<Argument> arguments() {
				return rc.argumentList().stream().map(this::map).toList();
			}

			public Map<String, String> finalArguments() {
				Map<String, String> arguments = new HashMap<>();
				this.arguments().forEach((a) -> arguments.put(a.name(), a.value()));
				artifact.parameters().stream()
						.filter((parameter) -> !arguments.containsKey(parameter.name()))
						.forEach((parameter) -> arguments.put(parameter.name(), parameter.value()));
				return arguments;
			}

			private Argument map(io.intino.legio.model.Argument a) {
				return new Argument() {
					@Override
					public String name() {
						return a.name();
					}

					@Override
					public String value() {
						return a.value();
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

	@Override
	public List<String> bugTrackingUsers() {
		return null;
	}

	@Override
	public Requirements requirements() {
		Artifact.Deployment.Requirements requirements = d.requirements();
		return requirements == null ? null : new Requirements() {
			@Override
			public int minHdd() {
				return 0;
			}

			@Override
			public int minMemory() {
				return requirements.memory().min();
			}

			@Override
			public int maxMemory() {
				return requirements.memory().max();
			}

			@Override
			public String jvmVersion() {
				return requirements.jVM().version();
			}

			@Override
			public Sync sync() {
				return null;
			}
		};
	}
}
