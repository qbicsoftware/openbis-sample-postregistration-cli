package life.qbic.samplestatusupdater

import life.qbic.samplestatusupdater.search.SampleRegistration
import life.qbic.samplestatusupdater.search.SearchOutput
import life.qbic.samplestatusupdater.update.UpdateSampleStatus

class UseCaseConnector implements SearchOutput {

    UpdateSampleStatus updateSampleStatus

    UseCaseConnector(UpdateSampleStatus updateSampleStatus){
        this.updateSampleStatus = updateSampleStatus
    }

    @Override
    Object newOpenBisSampleCodes(List<SampleRegistration> registrations) {
        registrations.each { sampleRegistration ->
            updateSampleStatus.updateSample(sampleRegistration.sampleCode, sampleRegistration.modificationTime)
        }
    }
}
