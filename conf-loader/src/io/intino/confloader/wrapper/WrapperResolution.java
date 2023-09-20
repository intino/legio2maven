package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.Artifact;

public class WrapperResolution implements Configuration.Artifact.WebResolution {

	private final Artifact.WebImports.Resolution dep;

	public WrapperResolution(Artifact.WebImports.Resolution dep) {
		this.dep = dep;
	}

	@Override
	public String name() {
		return dep.name$();
	}

	@Override
	public String version() {
		return dep.version();
	}
}
