package life.qbic.samplestatusupdater

import life.qbic.datamodel.services.Address
import life.qbic.datamodel.services.Location
import life.qbic.datamodel.services.Status
import life.qbic.samplestatusupdater.search.SearchOutput
import life.qbic.samplestatusupdater.update.UpdateSampleStatus

class UseCaseConnector implements SearchOutput {

    UpdateSampleStatus updateSampleStatus

    UseCaseConnector(UpdateSampleStatus updateSampleStatus){
        this.updateSampleStatus = updateSampleStatus
    }

    @Override
    Object newOpenBisSampleCodes(List<String> sampleCodes) {
        def location = createQBiCLocation()
        sampleCodes.each { code ->
            updateSampleStatus.update(code, location, Status.DATA_AT_QBIC)
        }
    }

    private static Location createQBiCLocation(){
        Location location = new Location()
        Address address = new Address()
        address.setStreet("Auf der Morgenstelle 10")

        location.address(address)
        location.arrivalDate(new Date())
        location.name("QBiC DataStore")
        location.responsiblePerson("QBiC team")
        location.responsibleEmail("support@qbic.zendesk.com")

        return location
    }
}
