package io.intino.legio2maven;

import io.intino.Configuration;
import io.intino.confloader.ConfigurationLoader;

import java.io.File;

public class Legio2Maven {
	public static void main(String[] args) {
		File root = new File(args[0]);
		File projectFile = new File(args[1]);
		File file = new File(root, "artifact.legio");
		Configuration conf = new ConfigurationLoader().load(file, projectFile);
		new PomCreator(conf, root).create(new File(root, "pom.xml"));
	}
}
