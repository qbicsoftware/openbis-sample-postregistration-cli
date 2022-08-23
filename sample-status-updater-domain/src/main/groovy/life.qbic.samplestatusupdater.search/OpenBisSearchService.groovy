package life.qbic.samplestatusupdater.search

import java.time.Instant

interface OpenBisSearchService {

    List<SampleRegistration> findNewOpenBisSamplesSince(Instant registeredSinceDate, List sampleTypeFilter)

}
