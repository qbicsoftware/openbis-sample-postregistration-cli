package life.qbic.samplestatusupdater.search

import java.time.Instant

class FindNewOpenBisSamples implements SearchInput {

    OpenBisSearchService search

    SearchOutput output

    FindNewOpenBisSamples(OpenBisSearchService search, SearchOutput output){
        this.output = output
        this.search = search
    }

    @Override
    def searchNewSamplesSince(Instant date) {
        def result = search.findNewOpenBisSamplesSince(date, new SampleTypeFilter())
        output.newOpenBisSampleCodes(result)
    }
}
