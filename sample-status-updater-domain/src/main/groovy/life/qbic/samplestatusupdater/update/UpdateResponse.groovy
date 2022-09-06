package life.qbic.samplestatusupdater.update

class UpdateResponse {

    String sampleCode

    boolean updateSuccessful


    @Override
    public String toString() {
        return new StringJoiner(", ", UpdateResponse.class.getSimpleName() + "[", "]")
                .add("sampleCode='" + sampleCode + "'")
                .add("updateSuccessful=" + updateSuccessful)
                .toString();
    }
}
