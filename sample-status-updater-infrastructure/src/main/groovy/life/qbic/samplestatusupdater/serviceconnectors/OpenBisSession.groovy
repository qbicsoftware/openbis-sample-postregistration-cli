package life.qbic.samplestatusupdater.serviceconnectors

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi
import ch.systemsx.cisd.common.spring.HttpInvokerUtils

class OpenBisSession {

    String url = url
    String user = user
    String pw = pw
    String token

    IApplicationServerApi api

    OpenBisSession(String url, String user, String pw) {
        this.url = url + IApplicationServerApi.SERVICE_URL
        this.user = user
        this.pw = pw
        api = HttpInvokerUtils.createServiceStub(IApplicationServerApi.class, this.url, 10000)
        token = api.login(this.user, this.pw)
    }

}
