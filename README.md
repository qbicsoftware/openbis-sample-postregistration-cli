<div align="center">

# Sample Status Updater CLI
 _Command-line utility to track the first status and location of newly registered samples._

[![Build Maven Package](https://github.com/qbicsoftware/sample-status-updater-cli/actions/workflows/build_package.yml/badge.svg)](https://github.com/qbicsoftware/sample-status-updater-cli/actions/workflows/build_package.yml)
[![Run Maven Tests](https://github.com/qbicsoftware/sample-status-updater-cli/actions/workflows/run_tests.yml/badge.svg)](https://github.com/qbicsoftware/sample-status-updater-cli/actions/workflows/run_tests.yml)
[![CodeQL](https://github.com/qbicsoftware/sample-status-updater-cli/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/qbicsoftware/sample-status-updater-cli/actions/workflows/codeql-analysis.yml)
[![release](https://img.shields.io/github/v/release/qbicsoftware/sample-status-updater-cli?include_prereleases)](https://github.com/qbicsoftware/sample-status-updater-cli/releases)

[![license](https://img.shields.io/github/license/qbicsoftware/sample-status-updater-cli)](https://github.com/qbicsoftware/sample-status-updater-cli/blob/main/LICENSE)
![language](https://img.shields.io/badge/language-java-blue.svg)
![framework](https://img.shields.io/badge/language-groovy-blue.svg)
</div>

## How to run

Create a runable version of this code with maven and java 8:

```
> mvn clean package
```

The JAR file will be created in the ``/target`` folder, for example:

```
|-target
|---sample-status-updater-cli-1.0.0.jar
|---...
```

Run the application with:

```
> java -jar sample-status-updater-cli-1.0.0.jar -h
Usage: OpenBIS status updater [-hv] -c=<config>
Command-line utility to...
  -c, --config=<config>   Property file in JSON to run the sample status updater.
  -h, --help              Prints usage and exists.
  -v, --version           Prints version and exits.


```
### Configuration

#### Properties

You have to provide a property file, that has to contain the following fields:

```
{
    "openbisAsUrl": "https://base/url",
    "openbisUser": "theuser",
    "openbisPw": "thepassword", 
    "serviceRegistryUrl": "http://test-registry.local:8500/v1",
    "serviceUser": "serviceUserName",
    "serviceUserPw": "theservicepassword",
    "lastSearchTimePoint": 2022-01-27T17:10:04.504Z"
}
```

The application currently tries to automatically update the `lastSearchDate` property, so it needs to have write permissions. 

## How to use

Deploy the service on the desired server and run it with a cron job regularly. 
Make sure the defined service address can be accessed. In the QBiC realm it will be the sample-tracking-service.

## License

This work is licensed under the [MIT license](https://mit-license.org/).
