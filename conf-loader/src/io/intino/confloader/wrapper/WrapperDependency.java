package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.Artifact;

import java.util.List;
import java.util.stream.Collectors;

public class WrapperDependency implements Configuration.Artifact.Dependency {

	private final Artifact.Imports.Dependency dep;

	public WrapperDependency(Artifact.Imports.Dependency dep) {
		this.dep = dep;
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

	@Override
	public void version(String s) {

	}

	@Override
	public String scope() {
		return dep.core$().conceptList().get(0).name();
	}

	@Override
	public List<Exclude> excludes() {
		return dep.excludeList().stream().map(e -> new Exclude() {
			@Override
			public String groupId() {
				return e.groupId();
			}

			@Override
			public String artifactId() {
				return e.artifactId();
			}
		}).collect(Collectors.toList());
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
