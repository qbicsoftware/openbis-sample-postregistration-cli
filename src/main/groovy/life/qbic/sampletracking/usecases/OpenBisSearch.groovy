package life.qbic.sampletracking.usecases

interface OpenBisSearch {

    List<String> findNewOpenBisSamplesSince(Date registeredSince)

}