package life.qbic.samplestatusupdater.search

import java.time.Instant

interface OpenBisSearchService {

    List<String> findNewOpenBisSamplesSince(Instant registeredSinceDate, List sampleTypeFilter)

}
