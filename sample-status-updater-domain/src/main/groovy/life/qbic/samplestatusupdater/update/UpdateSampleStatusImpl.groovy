package life.qbic.samplestatusupdater.update

import life.qbic.datamodel.services.Address
import life.qbic.datamodel.services.Location
import life.qbic.datamodel.services.Status

class UpdateSampleStatusImpl implements UpdateSampleStatus {

    SampleTrackingService service

    UpdateOutput output

    UpdateSampleStatusImpl(SampleTrackingService service, UpdateOutput output){
        this.service = service
        this.output = output
    }

    @Override
    def updateSampleAtQBiC(String sampleCode) {
        Location qbicLocation = createQBiCLocation()
        qbicLocation.status(Status.DATA_AT_QBIC)
        try {
            service.updateSample(sampleCode, qbicLocation)
            output.updateResponse(new UpdateResponse(sampleCode: sampleCode, updateSuccessful: true))
        } catch (SampleUpdateException e){
            output.updateResponse(new UpdateResponse(sampleCode: sampleCode, updateSuccessful: false))
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
