package life.qbic.samplestatusupdater.update


interface UpdateSampleStatus {

    def updateSampleAtQBiC(String sampleCode) throws SampleUpdateException

}