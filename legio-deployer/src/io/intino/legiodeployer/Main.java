package io.intino.legiodeployer;

import io.intino.Configuration;
import io.intino.alexandria.logger.Logger;
import io.intino.cesar.box.ApiAccessor;
import io.intino.confloader.ConfigurationLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {


	public static void main(String[] args)  {
		if (args.length < 3) return;
		Configuration configuration = configuration(args);
		ApiAccessor accessor = createAccessor(args[1], args[2]);
		ArtifactDeployer deployer = new ArtifactDeployer(configuration, accessor, new File(args[3]));
		for (Configuration.Deployment deployment : configuration.artifact().deployments()) {
			try {
				deployer.deployTo(deployment);
			} catch (IntinoException e) {
				Logger.error(e);
			}
		}

	}

	private static Configuration configuration(String[] args) {
		File file = new File(new File(args[0]), "artifact.legio");
		return new ConfigurationLoader().load(file);
	}

	private static ApiAccessor createAccessor(String url, String token) {
		return new ApiAccessor(urlOf(url.trim()), 1500, token);
	}

	public static URL urlOf(String cesar) {
		try {
			return new URL(cesar.startsWith("http") ? cesar : "https://" + cesar);
		} catch (MalformedURLException e) {
			return null;
		}
	}
}
