package cli

class SampleUpdateView {

    static displaySucessfulUpdate(String sample) {
        println "Sucessfully updated sample status for sample $sample!"
    }

    static displayFailingUpdate(String sample) {
        println " ERROR: Failed to update sample status for sample $sample!"
    }

}
