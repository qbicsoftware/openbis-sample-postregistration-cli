package cli

import life.qbic.samplestatusupdater.search.SearchOutput

class SampleSearchPresenter implements SearchOutput{
    @Override
    def newOpenBisSampleCodes(List<String> codes) {
        SampleSearchCliView.displayNewSamples(codes)
    }
}
