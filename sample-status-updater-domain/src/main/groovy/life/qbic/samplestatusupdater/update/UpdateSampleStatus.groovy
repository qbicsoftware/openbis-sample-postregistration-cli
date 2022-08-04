package life.qbic.samplestatusupdater.update

import java.time.Instant


interface UpdateSampleStatus {

    def updateSampleAtQBiC(String sampleCode) throws SampleUpdateException

    def updateSample(String sampleCode, Instant timepoint) throws SampleUpdateException

}