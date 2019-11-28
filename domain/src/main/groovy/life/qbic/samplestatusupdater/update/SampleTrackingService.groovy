package life.qbic.samplestatusupdater.update

import life.qbic.datamodel.services.Location

interface SampleTrackingService {

    def updateSample(String sampleCode, Location location)

}