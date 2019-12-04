package life.qbic.samplestatusupdater.search

class SampleTypeFilter<String> extends ArrayList<String> {

    SampleTypeFilter() {
        this.addAll(
                ["Q_TEST_SAMPLE",
                  "Q_BIOLOGICAL_ENTITY",
                  "Q_BIOLOGICAL_SAMPLE",
                  "Q_MS_RUN"
                 ])
    }

}
