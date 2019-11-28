package life.qbic.samplestatusupdater.update

class SampleUpdateException extends RuntimeException {

    SampleUpdateException(String message) {
        super(message)
    }

    SampleUpdateException(String message, Throwable t) {
        super(message, t)
    }

}
