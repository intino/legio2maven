package io.intino.legio2packagejson;

import io.intino.Configuration;
import io.intino.confloader.ConfigurationLoader;

import java.io.File;

public class Legio2PackageJson {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.err.println("Expected args in order: {module_directory} {project_file} {credentials_file}");
			return;
		}
		File root = new File(args[0]);
		File file = new File(root, "artifact.legio");
		Configuration conf = new ConfigurationLoader().load(file, args[1] != null && new File(args[1]).exists() ? new File(args[1]) : null);
		new PackageJsonCreator(conf, new File(args[2]), new File(root, "node_modules")).createPackageFile(root);
	}
}
