package io.intino.legio2maven;

import io.intino.legio.model.LegioGraph;
import io.intino.legio2maven.wrapper.WrapperConfiguration;
import io.intino.magritte.builder.StashBuilder;
import io.intino.magritte.framework.Graph;
import io.intino.magritte.io.Stash;
import tara.dsl.Legio;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Map;

public class Legio2Maven {


	public static void main(String[] args) {
		File root = new File(args[0]);
		File file = new File(root, "artifact.legio");
		StashBuilder builder = new StashBuilder(Map.of(file, Charset.defaultCharset()), new Legio(), "example", System.out);
		Stash[] build = builder.build();
		LegioGraph graph = new Graph().loadStashes(build).as(LegioGraph.class);
		System.out.println(graph.artifact().name$());
		new PomCreator(new WrapperConfiguration(graph), root).create(new File(root, "pom.xml"));
	}
}
