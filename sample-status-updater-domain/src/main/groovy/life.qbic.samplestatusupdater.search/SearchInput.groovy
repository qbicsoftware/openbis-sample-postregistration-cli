package life.qbic.samplestatusupdater.search

import java.time.Instant

interface SearchInput {

    /**
     * Search for new registered openBIS samples since the last search date.
     */
    def searchNewSamplesSince(Instant date)

}
