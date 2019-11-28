package life.qbic.samplestatusupdater.update

import life.qbic.datamodel.services.Location
import life.qbic.datamodel.services.Status

class UpdateSampleStatusImpl implements UpdateSampleStatus {

    SampleTrackingService service

    UpdateOutput output

    UpdateSampleStatusImpl(SampleTrackingService service, UpdateOutput output){
        this.service = service
        this.output = output
    }

    @Override
    def update(String sampleCode, Location location, Status status) {
        Location updatedLocation = updateLocationStatus(location, status)
        try {
            service.updateSample(sampleCode, updatedLocation)
            output.updateResponse(new UpdateResponse(sampleCode: sampleCode, updateSuccessful: true))
        } catch (SampleUpdateException e){
            output.updateResponse(new UpdateResponse(sampleCode: sampleCode, updateSuccessful: false))
        }

    }

    private static Location updateLocationStatus(Location location, Status status) {
        location.status(status)
    }
}
