package life.qbic.sampletracking.usecases

import life.qbic.datamodel.services.Location
import life.qbic.datamodel.services.Status

class UpdateSampleStatus {

    String sampleCode

    Location location

    Status newStatus

    UpdateSampleStatus(String sampleCode, Location location, Status newStatus){
        this.sampleCode = sampleCode
        this.location = location
        this.newStatus = newStatus
    }

    void update(SampleTrackingService connector) {
        location.status = newStatus
        connector.updateSample(sampleCode, location)
    }

}
