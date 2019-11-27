# Sample command-line Tool

[![Build Status](https://travis-ci.com/qbicsoftware/sample-status-updater-cli.svg?branch=development)](https://travis-ci.com/qbicsoftware/sample-status-updater-cli)[![Code Coverage]( https://codecov.io/gh/qbicsoftware/sample-status-updater-cli/branch/development/graph/badge.svg)](https://codecov.io/gh/qbicsoftware/sample-status-updater-cli)

Sample command-line Tool, version 1.0.0-SNAPSHOT - Command-line utility to...

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
    "lastSearchDate": "2019-10-10"
}
```
