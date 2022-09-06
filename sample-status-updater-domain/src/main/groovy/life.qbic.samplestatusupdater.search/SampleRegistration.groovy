package life.qbic.samplestatusupdater.search


import groovy.transform.EqualsAndHashCode

import java.time.Instant

@EqualsAndHashCode
class SampleRegistration {

  final String sampleCode
  final Instant registrationTime

  SampleRegistration(String sampleCode, Instant registration) {
    Objects.requireNonNull(sampleCode)
    Objects.requireNonNull(registration)
    this.sampleCode = sampleCode
    this.registrationTime = registration
  }


}
