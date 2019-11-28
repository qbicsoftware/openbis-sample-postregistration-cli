package cli

class SampleSearchCliView {

    static displayNewSamples(List<String> newRegisteredSamples) {
        newRegisteredSamples.each {
            println "Found a new registered Sample: $it"
        }
    }

}
