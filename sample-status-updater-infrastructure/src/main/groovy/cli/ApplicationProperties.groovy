package cli

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class ApplicationProperties {

    String propertiesFile

    ApplicationProperties(String propertiesFile) {
        this.propertiesFile = propertiesFile
    }

    def parse(){
        new JsonSlurper().parseText(new File(propertiesFile).text)
    }

    def updatePropertyFile(Map properties){
        def jsonString = JsonOutput.toJson(properties)
        def file = new File(propertiesFile).withWriter {
            it.write(JsonOutput.prettyPrint(jsonString))
        }
    }

}
