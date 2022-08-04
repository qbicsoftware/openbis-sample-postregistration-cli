package life.qbic.samplestatusupdater.update

import life.qbic.datamodel.samples.Location
import life.qbic.datamodel.samples.Status

import java.time.Instant

interface SampleTrackingService {

    def registerFirstSampleLocation(String sampleCode, Location location) throws SampleUpdateException

    def registerSampleStatus(String sampleCode, Status status, Instant timepoint) throws SampleUpdateException

}