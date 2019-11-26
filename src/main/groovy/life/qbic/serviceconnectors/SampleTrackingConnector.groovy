package life.qbic.serviceconnectors

import life.qbic.datamodel.services.Location
import life.qbic.sampletracking.usecases.SampleTrackingService
import life.qbic.services.Service


class SampleTrackingConnector implements SampleTrackingService {

    ServiceUserCredentials credentials

    Service service

    SampleTrackingConnector(Service sampleTrackingService, ServiceUserCredentials credentials){
        this.service = sampleTrackingService
        this.credentials = credentials
    }

    @Override
    def updateSample(String sampleCode, Location location) {
        return null
    }
}
