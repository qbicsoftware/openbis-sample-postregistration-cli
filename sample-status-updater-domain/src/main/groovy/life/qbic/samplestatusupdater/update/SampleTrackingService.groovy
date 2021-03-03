package life.qbic.samplestatusupdater.update

import life.qbic.datamodel.samples.Location

interface SampleTrackingService {

    def registerFirstSampleLocation(String sampleCode, Location location) throws SampleUpdateException

}