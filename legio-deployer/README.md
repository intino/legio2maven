# legio-deployer

Post a deploy to cesar

## How to use it.

    java -jar legio-deployer.jar {artifact_directory} {project_legio_file} ... 
        {cesar_url} {cesar_token} {file_with_artifactories_credentials}.

The file with artifactory credentials is an TSV with the columns: mavenID, user and password/token

It will post a deploy to all deployments declared in artifact