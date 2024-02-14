package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.Artifact;
import io.intino.legio.model.LegioGraph;

import java.util.Collections;
import java.util.List;

import static io.intino.confloader.Safe.safe;


public class WrapperDatahub implements Configuration.Artifact.Dependency.DataHub {

	private final Artifact artifact;

	public WrapperDatahub(Artifact artifact) {
		this.artifact = artifact;
	}

	@Override
	public String groupId() {
		return safe(() -> artifact.dataHub().groupId());
	}

	@Override
	public String artifactId() {
		return safe(() -> artifact.dataHub().artifactId());
	}

	@Override
	public String version() {
		return safe(() -> artifact.dataHub().version());
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
	public boolean toModule() {
		return false;
	}

	@Override
	public void toModule(boolean b) {

	}
}
