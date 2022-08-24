package life.qbic.samplestatusupdater.search

import groovy.transform.EqualsAndHashCode

import java.time.Instant

@EqualsAndHashCode
class SampleRegistration {

  final String sampleCode
  final Instant modificationTime

  SampleRegistration(String sampleCode, Instant registration) {
    this.sampleCode = sampleCode
    this.modificationTime = modificationTime
  }


}
