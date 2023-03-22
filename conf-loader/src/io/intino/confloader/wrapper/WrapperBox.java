package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.Artifact;

import static io.intino.confloader.Safe.safe;

public class WrapperBox implements Configuration.Artifact.Box {

	private final Artifact artifact;

	public WrapperBox(Artifact artifact) {
		this.artifact = artifact;
	}

	@Override
	public String language() {
		return "Konos";
	}

	@Override
	public String version() {
		return safe(() -> artifact.box().version());
	}

	@Override
	public String effectiveVersion() {
		return safe(() -> artifact.box().effectiveVersion());
	}

	@Override
	public void effectiveVersion(String s) {

	}

	@Override
	public String targetPackage() {
		return safe(() -> artifact.box().targetPackage());
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
