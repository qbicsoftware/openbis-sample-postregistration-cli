package life.qbic.samplestatusupdater

import life.qbic.samplestatusupdater.search.SearchOutput
import life.qbic.samplestatusupdater.update.UpdateSampleStatus

import java.time.Instant

class UseCaseConnector implements SearchOutput {

    UpdateSampleStatus updateSampleStatus

    UseCaseConnector(UpdateSampleStatus updateSampleStatus){
        this.updateSampleStatus = updateSampleStatus
    }

    @Override
    Object newOpenBisSampleCodes(List<String> sampleCodes) {
        Instant timepoint = Instant.now()
        sampleCodes.each { code ->
            updateSampleStatus.updateSample(code, timepoint)
        }
    }
}
