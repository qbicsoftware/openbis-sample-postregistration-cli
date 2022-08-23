package life.qbic.samplestatusupdater.search

import java.time.Instant

interface OpenBisSearchService {

    List<SampleModification> findNewOpenBisSamplesSince(Instant registeredSinceDate, List sampleTypeFilter)

}
