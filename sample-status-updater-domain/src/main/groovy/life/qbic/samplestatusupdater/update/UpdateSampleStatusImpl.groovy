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
        qbicLocation.status(Status.METADATA_REGISTERED)
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
        address.street ="Auf der Morgenstelle 10"
        address.affiliation = "QBiC"
        address.zipCode = 72076
        address.country = "Germany"

        location.address = address
        location.arrivalDate = new Date()
        location.name = "QBiC"
        location.responsiblePerson ="QBiC Team"
        location.responsibleEmail ="support@qbic.zendesk.com"

        return location
    }
}
