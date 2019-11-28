package life.qbic.samplestatusupdater.search

interface SearchInput {

    /**
     * Search for new registered openBIS samples since the last search date.
     */
    def searchNewSamplesSince(Date date)

}