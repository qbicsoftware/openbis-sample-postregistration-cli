package life.qbic.samplestatusupdater.cli

import life.qbic.samplestatusupdater.update.UpdateOutput
import life.qbic.samplestatusupdater.update.UpdateResponse

class SampleUpdatePresenter implements UpdateOutput{

    @Override
    def updateResponse(UpdateResponse response) {
        if (response.updateSuccessful){
            SampleUpdateView.displaySucessfulUpdate(response.sampleCode)
        } else {
            SampleUpdateView.displayFailingUpdate(response.sampleCode)
        }
    }
}
