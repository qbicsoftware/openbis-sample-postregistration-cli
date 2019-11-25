package life.qbic.sampletracking.usecases

class FindNewOpenBisSamples{

    Date lastSearchDate

    OpenBisSearch search

    FindNewOpenBisSamples(Date lastSearchDate, OpenBisSearch search){
        this.lastSearchDate = lastSearchDate
        this.search = search
    }

    /**
     * Find new registered openBIS samples since the last search date.
     *
     * @return A list of sample codes
     */
    List<String> findNewOpenBisSamples() {
        search.findNewOpenBisSamplesSince(lastSearchDate)
    }

}
