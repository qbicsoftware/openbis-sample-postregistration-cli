package life.qbic.samplestatusupdater.update

import groovy.util.logging.Log4j2
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.RxHttpClient
import life.qbic.datamodel.services.Location
import life.qbic.samplestatusupdater.ServiceUserCredentials
import life.qbic.services.Service

@Log4j2
class SampleTrackingConnector implements SampleTrackingService {

    ServiceUserCredentials credentials

    Service service

    SampleTrackingConnector(Service sampleTrackingService, ServiceUserCredentials credentials){
        this.service = sampleTrackingService
        this.credentials = credentials
    }

    @Override
    def updateSample(String sampleCode, Location location) throws SampleUpdateException{
        HttpClient client = RxHttpClient.create(service.rootUrl)
        //TODO this is only a workaround, as the client seems not to prepend the base url.
        URI sampleUri = new URI("${service.rootUrl.toExternalForm()}/samples/$sampleCode/currentLocation/")
        log.debug("final uri is $sampleUri")
        HttpRequest request = HttpRequest.POST(sampleUri, location).basicAuth(credentials.name, credentials.pw)
        client.withCloseable {
            def response = it.toBlocking().exchange(request)
            validateResponse(response)
        }
    }

    private static void validateResponse(HttpResponse response ){
        def statusCode = response.status.code
        if (statusCode != 200) {
            throw new SampleUpdateException("Could not update sample status, " +
                    "the http response code was %code. \n${response.reason()}")
        }
    }
}
