package life.qbic.samplestatusupdater.search

interface OpenBisSearch {

    List<String> findNewOpenBisSamplesSince(Date registeredSinceDate)

}