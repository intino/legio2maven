package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.LegioGraph;

import java.util.Collections;
import java.util.List;

import static io.intino.confloader.Safe.safe;


public class WrapperDatahub implements Configuration.Artifact.Dependency.DataHub {

	private final LegioGraph graph;

	public WrapperDatahub(LegioGraph graph) {
		this.graph = graph;
	}

	@Override
	public String groupId() {
		return safe(() -> graph.artifact().dataHub().groupId());
	}

	@Override
	public String artifactId() {
		return safe(() -> graph.artifact().dataHub().artifactId());
	}

	@Override
	public String version() {
		return safe(() -> graph.artifact().dataHub().version());
	}

	@Override
	public void version(String s) {

	}

	@Override
	public String scope() {
		return "COMPILE";
	}

	@Override
	public List<Exclude> excludes() {
		return Collections.emptyList();
	}

	@Override
	public String effectiveVersion() {
		return null;
	}

	@Override
	public void effectiveVersion(String s) {

	}

	@Override
	public boolean transitive() {
		return false;
	}

	@Override
	public boolean resolved() {
		return false;
	}

	@Override
	public void resolved(boolean b) {

	}

	@Override
	public boolean toModule() {
		return false;
	}

	@Override
	public void toModule(boolean b) {

	}
}
