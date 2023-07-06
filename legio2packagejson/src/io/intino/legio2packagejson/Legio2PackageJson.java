package io.intino.legio2packagejson;

import io.intino.Configuration;
import io.intino.confloader.ConfigurationLoader;

import java.io.File;

public class Legio2PackageJson {


	public static void main(String[] args) {
		File root = new File(args[0]);
		File file = new File(root, "artifact.legio");
		Configuration conf = new ConfigurationLoader().load(file);
		new PackageJsonCreator(conf, new File(args[1]), new File(root, "node_modules")).createPackageFile(root);
	}
}
