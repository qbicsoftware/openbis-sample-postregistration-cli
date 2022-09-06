package life.qbic.samplestatusupdater.search

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.EqualsAndHashCode

import java.time.Instant

@EqualsAndHashCode
class SampleRegistration {

  final String sampleCode
  final Instant modificationTime

  SampleRegistration(String sampleCode, Instant registration) {
    Objects.requireNonNull(sampleCode)
    Objects.requireNonNull(registration)
    this.sampleCode = sampleCode
    this.modificationTime = modificationTime
  }


}
