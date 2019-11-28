package life.qbic.samplestatusupdater.update

import life.qbic.datamodel.services.Location
import life.qbic.datamodel.services.Status

class UpdateSampleStatusImpl implements UpdateSampleStatus {

    SampleTrackingService service

    UpdateSampleStatusImpl(SampleTrackingService service){
        this.service = service
    }

    @Override
    def update(String sampleCode, Location location, Status status) throws SampleUpdateException{
        Location updatedLocation = updateLocationStatus(location, status)
        try {
            service.updateSample(sampleCode, updatedLocation)
        } catch (Exception e) {
            throw new SampleUpdateException("Update of sample $sampleCode went wrong.", e)
        }
    }

    private static Location updateLocationStatus(Location location, Status status) {
        location.status(status)
    }
}
