package io.intino.confloader.wrapper;

import io.intino.Configuration;
import io.intino.legio.model.LegioGraph;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WrapperConfiguration implements Configuration {

	private final LegioGraph graph;

	public WrapperConfiguration(LegioGraph graph) {
		this.graph = graph;
	}

	@Override
	public Artifact artifact() {
		return new WrapperArtifact(graph.artifact());

	}


	@Override
	public List<Server> servers() {
		return null;
	}

	@Override
	public List<RunConfiguration> runConfigurations() {
		return null;
	}

	@Override
	public List<Repository> repositories() {
		List<Repository> repos = graph.repositoryList().stream().map(WrapperReleaseRepository::new).collect(toList());
		repos.addAll(graph.repositoryList().stream().map(WrapperSnapshotRepository::new).toList());
		return repos;
	}
}
