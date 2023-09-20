package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.Artifact;

public class WrapperWebComponent implements Configuration.Artifact.WebComponent {

	private final Artifact.Imports.Web dep;

	public WrapperWebComponent(Artifact.Imports.Web dep) {
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
