package cli

import life.qbic.samplestatusupdater.update.UpdateOutput
import life.qbic.samplestatusupdater.update.UpdateResponse

class SampleUpdatePresenter implements UpdateOutput{
    @Override
    def newOpenBisSampleCodes(List<String> codes) {
        SampleSearchCliView.displayNewSamples(codes)
    }

    @Override
    def updateResponse(UpdateResponse response) {
        return null
    }
}
