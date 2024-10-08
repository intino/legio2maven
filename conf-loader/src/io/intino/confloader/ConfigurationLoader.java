package io.intino.confloader;

import io.intino.Configuration;
import io.intino.confloader.wrapper.WrapperConfiguration;
import io.intino.legio.model.LegioGraph;
import io.intino.magritte.builder.StashBuilder;
import io.intino.magritte.io.model.Stash;
import tara.dsl.Legio;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Map;

public class ConfigurationLoader {

	public Configuration load(File artifactFile, File projectFile) {
		StashBuilder builder = new StashBuilder(sources(artifactFile, projectFile), new Legio(), "example", System.out);
		Stash[] build = builder.build();
		return new WrapperConfiguration(LegioGraph.load(build));
	}

	private static Map<File, Charset> sources(File artifactFile, File projectFile) {
		return projectFile != null && projectFile.exists() ?
				Map.of(artifactFile, Charset.defaultCharset(), projectFile, Charset.defaultCharset()) :
				Map.of(artifactFile, Charset.defaultCharset());
	}
}
