package life.qbic.samplestatusupdater.search

import groovy.transform.EqualsAndHashCode

import java.time.Instant

@EqualsAndHashCode
class SampleModification {

  final String sampleCode
  final Instant modificationTime

  SampleModification(String sampleCode, Instant modificationTime) {
    this.sampleCode = sampleCode
    this.modificationTime = modificationTime
  }


}
