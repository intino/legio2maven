package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.Artifact;

import java.util.Collections;
import java.util.List;

import static io.intino.confloader.Safe.safe;


public class WrapperArchetype implements Configuration.Artifact.Dependency.Archetype {

	private final Artifact artifact;

	public WrapperArchetype(Artifact artifact) {
		this.artifact = artifact;
	}

	@Override
	public String groupId() {
		return safe(() -> artifact.archetype().groupId());
	}

	@Override
	public String artifactId() {
		return safe(() -> artifact.archetype().artifactId());
	}

	@Override
	public String version() {
		return safe(() -> artifact.archetype().version());
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

	@Override
	public Configuration root() {
		return null;
	}

	@Override
	public Configuration.ConfigurationNode owner() {
		return null;
	}
}
