package life.qbic.sampletracking.usecases

import life.qbic.datamodel.services.Location

interface SampleTrackingService {

    def updateSample(String sampleCode, Location location)

}