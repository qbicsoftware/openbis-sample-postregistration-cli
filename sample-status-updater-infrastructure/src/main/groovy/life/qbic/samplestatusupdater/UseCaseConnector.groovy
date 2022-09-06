package life.qbic.samplestatusupdater

import life.qbic.samplestatusupdater.search.SampleRegistration
import life.qbic.samplestatusupdater.search.SearchOutput
import life.qbic.samplestatusupdater.update.UpdateSampleStatus
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class UseCaseConnector implements SearchOutput {

    private static final Logger log = LogManager.getLogger(UseCaseConnector.class);

    UpdateSampleStatus updateSampleStatus

    UseCaseConnector(UpdateSampleStatus updateSampleStatus){
        this.updateSampleStatus = updateSampleStatus
    }

    @Override
    Object newOpenBisSampleCodes(List<SampleRegistration> registrations) {
        log.info("found ${registrations.size()} new registrations.")
        registrations.each { sampleRegistration ->
            updateSampleStatus.updateSample(sampleRegistration.sampleCode, sampleRegistration.registrationTime)
        }
    }
}
