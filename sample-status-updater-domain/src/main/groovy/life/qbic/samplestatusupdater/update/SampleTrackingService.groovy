package life.qbic.samplestatusupdater.update

import life.qbic.datamodel.services.Location

interface SampleTrackingService {

    def registerFirstSampleLocation(String sampleCode, Location location) throws SampleUpdateException

}