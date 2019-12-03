package life.qbic.samplestatusupdater.cli

import groovy.util.logging.Log4j2

@Log4j2
class SampleUpdateView {

    static displaySucessfulUpdate(String sample) {
        log.info "Sample $sample location is set to QBiC."
    }

    static displayFailingUpdate(String sample) {
        log.error " ERROR: Failed to update sample status for sample $sample!"
    }

}
