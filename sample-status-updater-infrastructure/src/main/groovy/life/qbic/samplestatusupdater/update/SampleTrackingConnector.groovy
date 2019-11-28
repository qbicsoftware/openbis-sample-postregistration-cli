package life.qbic.samplestatusupdater.update

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.RxHttpClient
import life.qbic.datamodel.services.Location
import life.qbic.samplestatusupdater.ServiceUserCredentials
import life.qbic.services.Service

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
        HttpRequest request = HttpRequest.POST("samples/$sampleCode/currentLocation/",
                location).basicAuth(credentials.name, credentials.pw)
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
