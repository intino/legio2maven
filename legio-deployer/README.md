# legio2maven

Transform an artifact.legio in pom.xml

## How to use it.

    java -jar legio-deployer.jar {artifact_directory} ... 
        {cesar_url} {cesar_token} {file_with_artifactories_credentials}.

The file with artifactory credentials is an TSV with the columns: mavenID, user and password/token

It will post a deploy to all deployments declared in artifact