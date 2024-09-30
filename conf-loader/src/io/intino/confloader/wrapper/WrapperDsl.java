package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.Artifact;

import static io.intino.confloader.Safe.safe;

public class WrapperDsl implements Configuration.Artifact.Dsl {
	private final Artifact artifact;

	public WrapperDsl(Artifact artifact) {
		this.artifact = artifact;
	}

	@Override
	public String name() {
		return artifact.dsl(0).name();
	}

	@Override
	public String version() {
		return safe(() -> artifact.dsl(0).version());
	}

	@Override
	public Level level() {
		return Level.MetaModel;
	}

	@Override
	public String generationPackage() {
		return safe(() -> artifact.box().targetPackage());
	}

	@Override
	public String effectiveVersion() {
		return safe(() -> artifact.dsl(0).version());
	}

	@Override
	public void effectiveVersion(String s) {

	}

	@Override
	public void version(String s) {

	}

	@Override
	public Builder builder() {
		return null;
	}

	@Override
	public Runtime runtime() {
		return null;
	}

	@Override
	public OutputDsl outputDsl() {
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
}
