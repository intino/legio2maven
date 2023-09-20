package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.Artifact;

public class WrapperWebArtifact implements Configuration.Artifact.WebArtifact {
	private final Artifact.WebImports.WebArtifact dep;

	public WrapperWebArtifact(Artifact.WebImports.WebArtifact dep) {
		this.dep = dep;
	}

	@Override
	public String name() {
		return dep.name$();
	}

	@Override
	public String groupId() {
		return dep.groupId();
	}

	@Override
	public String artifactId() {
		return dep.artifactId();
	}

	@Override
	public String version() {
		return dep.version();
	}
}