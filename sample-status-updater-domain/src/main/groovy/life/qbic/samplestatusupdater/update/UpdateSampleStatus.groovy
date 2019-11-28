package life.qbic.samplestatusupdater.update

import life.qbic.datamodel.services.Location
import life.qbic.datamodel.services.Status

interface UpdateSampleStatus {

    def update(String sampleCode, Location location, Status status) throws SampleUpdateException

}