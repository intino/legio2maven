package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.LegioGraph;

import static io.intino.confloader.Safe.safe;

public class WrapperBox implements Configuration.Artifact.Box {

	private final LegioGraph graph;

	public WrapperBox(LegioGraph graph) {
		this.graph = graph;
	}

	@Override
	public String language() {
		return "Konos";
	}

	@Override
	public String version() {
		return safe(() -> graph.artifact().box().version());
	}

	@Override
	public String effectiveVersion() {
		return safe(() -> graph.artifact().box().effectiveVersion());
	}

	@Override
	public void effectiveVersion(String s) {

	}

	@Override
	public String targetPackage() {
		return safe(() -> graph.artifact().box().targetPackage());
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
