package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.Artifact;

public class WrapperPackDependency implements Configuration.Artifact.PackDependency {

	private final Artifact.WebImports.PackDependency dep;

	public WrapperPackDependency(Artifact.WebImports.PackDependency dep) {
		this.dep = dep;
	}

	@Override
	public String name() {
		return dep.name();
	}

	@Override
	public String version() {
		return dep.version();
	}
}
