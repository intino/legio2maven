package io.intino.legiodeployer;

import io.intino.Configuration;
import io.intino.alexandria.exceptions.BadRequest;
import io.intino.alexandria.exceptions.Forbidden;
import io.intino.alexandria.exceptions.InternalServerError;
import io.intino.alexandria.exceptions.Unauthorized;
import io.intino.cesar.box.ApiAccessor;
import io.intino.cesar.box.schemas.ProcessDeployment;
import io.intino.cesar.box.schemas.ProcessDeployment.Artifactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.intino.confloader.Safe.safe;
import static java.util.stream.Collectors.toList;

public class ArtifactDeployer {
	private final Configuration configuration;
	private final ApiAccessor accessor;

	public ArtifactDeployer(Configuration configuration, ApiAccessor accessor) {
		this.configuration = configuration;
		this.accessor = accessor;
	}

	public void deployTo(Configuration.Deployment deployment) throws IntinoException {
		try {
			final Configuration.Artifact.Package aPackage = safe(() -> configuration.artifact().packageConfiguration());
			if (aPackage == null) throw new IntinoException("Package configuration not found");
			if (!aPackage.isRunnable())
				throw new IntinoException("Packaging must be runnable and have Main Class");
			if (deployment.server() == null)
				throw new IntinoException("Server " + deployment.server().name() + " not found");
			List<Configuration.Parameter> incorrectParameters = incorrectParameters(deployment.runConfiguration().finalArguments());
			if (!incorrectParameters.isEmpty())
				throw new IntinoException("Parameters missed: " + incorrectParameters.stream().map(Configuration.Parameter::name).collect(Collectors.joining("; ")));
			accessor.postDeployProcess(createDeployment(aPackage, deployment));
		} catch (Forbidden | BadRequest | InternalServerError | Unauthorized e) {
			throw new IntinoException(e.getMessage());
		}
	}

	private ProcessDeployment createDeployment(Configuration.Artifact.Package packageConfiguration, Configuration.Deployment destination) {
		final String classpathPrefix = packageConfiguration.classpathPrefix();
		return new ProcessDeployment().
				groupId(configuration.artifact().groupId()).artifactId(configuration.artifact().name().toLowerCase()).version(configuration.artifact().version()).
				jvmOptions(destination.runConfiguration().vmOptions()).
				artifactoryList(artifactories()).
				packaging(new ProcessDeployment.Packaging().mainClass(packageConfiguration.mainClass()).parameterList(extractParameters(destination.runConfiguration())).classpathPrefix(classpathPrefix == null || classpathPrefix.isEmpty() ? "dependency" : classpathPrefix)).
				destinationServer(destination.server().name());
	}

	private List<ProcessDeployment.Packaging.Parameter> extractParameters(Configuration.RunConfiguration configuration) {
		return configuration.finalArguments().entrySet().stream().map(this::parametersFromNode).collect(toList());
	}

	private List<Artifactory> artifactories() {
		List<Configuration.Repository> repositories = new ArrayList<>(configuration.repositories());
		return repositories.stream().map(entry -> new Artifactory().url(entry.url()).id(entry.identifier())).collect(toList());
	}

	private ProcessDeployment.Packaging.Parameter parametersFromNode(Map.Entry<String, String> node) {
		return new ProcessDeployment.Packaging.Parameter().name(node.getKey()).value(node.getValue());
	}

	private List<Configuration.Parameter> incorrectParameters(Map<String, String> arguments) {
		return configuration.artifact().parameters().stream().filter(p -> !arguments.containsKey(p.name()) || arguments.get(p.name()) == null).collect(Collectors.toList());
	}
}
