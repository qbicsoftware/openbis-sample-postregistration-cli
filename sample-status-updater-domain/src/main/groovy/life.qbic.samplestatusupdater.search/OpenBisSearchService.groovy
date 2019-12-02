package life.qbic.samplestatusupdater.search

interface OpenBisSearchService {

    List<String> findNewOpenBisSamplesSince(Date registeredSinceDate)

}