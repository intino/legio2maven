package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.Artifact;

public class WrapperWebComponent implements Configuration.Artifact.WebComponent {

	private final Artifact.WebImports.WebComponent dep;

	public WrapperWebComponent(Artifact.WebImports.WebComponent dep) {
		this.dep = dep;
	}

	@Override
	public String name() {
		return dep.url();
	}

	@Override
	public String version() {
		return dep.version();
	}


}
