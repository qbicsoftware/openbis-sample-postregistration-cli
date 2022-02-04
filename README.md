# Sample command-line Tool

[![Build Maven Package](https://github.com/qbicsoftware/sample-status-updater-cli/actions/workflows/build_package.yml/badge.svg)](https://github.com/qbicsoftware/sample-status-updater-cli/actions/workflows/build_package.yml)
[![Run Maven Tests](https://github.com/qbicsoftware/sample-status-updater-cli/actions/workflows/run_tests.yml/badge.svg)](https://github.com/qbicsoftware/sample-status-updater-cli/actions/workflows/run_tests.yml)
[![CodeQL](https://github.com/qbicsoftware/sample-status-updater-cli/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/qbicsoftware/sample-status-updater-cli/actions/workflows/codeql-analysis.yml)
[![release](https://img.shields.io/github/v/release/qbicsoftware/sample-status-updater-cli?include_prereleases)](https://github.com/qbicsoftware/sample-status-updater-cli/releases)

[![license](https://img.shields.io/github/license/qbicsoftware/sample-status-updater-cli)](https://github.com/qbicsoftware/sample-status-updater-cli/blob/main/LICENSE)
![language](https://img.shields.io/badge/language-java-blue.svg)
![framework](https://img.shields.io/badge/language-groovy-blue.svg)
Sample command-line Tool - Command-line utility to add the first location of sample tracking information

## Author
Created by Sven Fillinger (sven.fillinger@qbic.uni-tuebingen.de).

## Description

## How to Install

Download the application and run it with:

```
> java -jar sample-status-updater-cli.jar -h
Usage: OpenBIS status updater [-hv] -c=<config>
Command-line utility to...
  -c, --config=<config>   Property file in JSON to run the sample status updater.
  -h, --help              Prints usage and exists.
  -v, --version           Prints version and exits.


```

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
