package io.intino.confloader;

import io.intino.Configuration;
import io.intino.confloader.wrapper.WrapperConfiguration;
import io.intino.legio.model.LegioGraph;
import io.intino.magritte.builder.StashBuilder;
import io.intino.magritte.framework.Graph;
import io.intino.magritte.io.Stash;
import tara.dsl.Legio;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Map;

public class ConfigurationLoader {

	public Configuration load(File legio) {
		StashBuilder builder = new StashBuilder(Map.of(legio, Charset.defaultCharset()), new Legio(), "example", System.out);
		Stash[] build = builder.build();
		LegioGraph graph = new Graph().loadStashes(build).as(LegioGraph.class);
		return new WrapperConfiguration(graph);
	}
}
