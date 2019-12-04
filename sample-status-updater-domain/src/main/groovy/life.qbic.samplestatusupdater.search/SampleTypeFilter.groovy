package life.qbic.samplestatusupdater.search

/**
 * Filter that holds a preset of openBIS samples to filter for
 *
 * @param <String> A sample type string like "Q_BIOLOGICAL_SAMPLE"
 */
class SampleTypeFilter<String> extends ArrayList<String> {

    SampleTypeFilter() {
        this.addAll(
                ["Q_TEST_SAMPLE",
                  "Q_BIOLOGICAL_ENTITY",
                  "Q_BIOLOGICAL_SAMPLE",
                 ])
    }

}
