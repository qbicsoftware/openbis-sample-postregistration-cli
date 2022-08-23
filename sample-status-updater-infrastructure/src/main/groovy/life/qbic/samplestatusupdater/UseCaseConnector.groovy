package life.qbic.samplestatusupdater

import life.qbic.samplestatusupdater.search.SampleModification
import life.qbic.samplestatusupdater.search.SearchOutput
import life.qbic.samplestatusupdater.update.UpdateSampleStatus

import java.time.Instant

class UseCaseConnector implements SearchOutput {

    UpdateSampleStatus updateSampleStatus

    UseCaseConnector(UpdateSampleStatus updateSampleStatus){
        this.updateSampleStatus = updateSampleStatus
    }

    @Override
    Object newOpenBisSampleCodes(List<SampleModification> sampleModifications) {
        sampleModifications.each { modification ->
            updateSampleStatus.updateSample(modification.sampleCode, modification.modificationTime)
        }
    }
}
