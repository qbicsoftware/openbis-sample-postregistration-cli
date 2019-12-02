package cli

import groovy.util.logging.Log4j2

@Log4j2
class SampleUpdateView {

    static displaySucessfulUpdate(String sample) {
        log.info "Sucessfully updated sample status for sample $sample!"
    }

    static displayFailingUpdate(String sample) {
        log.error " ERROR: Failed to update sample status for sample $sample!"
    }

}
