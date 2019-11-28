package life.qbic.samplestatusupdater.serviceconnectors

import life.qbic.services.ConsulServiceFactory
import life.qbic.services.Service
import life.qbic.services.ServiceType
import life.qbic.services.connectors.ConsulConnector

class ServiceSearch {

    static List<Service> findSampleTrackingService(URL serviceRegistryUrl) {
        List<Service> serviceList = []
        def connector = new ConsulConnector(serviceRegistryUrl)
        connector.withCloseable {
            ConsulServiceFactory factory = new ConsulServiceFactory(it)
            serviceList.addAll(factory.getServicesOfType(ServiceType.SAMPLE_TRACKING))
        }
        return serviceList
    }
}
