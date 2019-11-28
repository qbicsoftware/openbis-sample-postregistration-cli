package life.qbic.samplestatusupdater.search

class FindNewOpenBisSamples implements SearchInput {

    OpenBisSearch search

    SearchOutput output

    FindNewOpenBisSamples(OpenBisSearch search, SearchOutput output){
        this.output = output
        this.search = search
    }

    @Override
    def searchNewSamplesSince(Date date) {
        def result = search.findNewOpenBisSamplesSince(date)
        output.newOpenBisSampleCodes(result)
    }
}
