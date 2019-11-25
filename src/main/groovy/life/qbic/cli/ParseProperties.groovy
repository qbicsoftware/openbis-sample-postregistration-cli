package life.qbic.cli

import groovy.json.JsonSlurper

class ParseProperties {

    String propertiesFile

    ParseProperties(String propertiesFile) {
        this.propertiesFile = propertiesFile
    }

    def parse(){
        new JsonSlurper().parseText(new File(propertiesFile).text)
    }

}
