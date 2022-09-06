package life.qbic.samplestatusupdater.update

import life.qbic.datamodel.people.Address
import life.qbic.datamodel.samples.Location
import life.qbic.datamodel.samples.Status
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

import java.time.Instant

class UpdateSampleStatusImpl implements UpdateSampleStatus {
    private static final Logger log = LogManager.getLogger(UpdateSampleStatusImpl.class);

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
            service.registerFirstSampleLocation(sampleCode, qbicLocation)
            output.updateResponse(new UpdateResponse(sampleCode: sampleCode, updateSuccessful: true))
        } catch (SampleUpdateException e){
            log.error(e.getMessage(), e)
            output.updateResponse(new UpdateResponse(sampleCode: sampleCode, updateSuccessful: false))
        }
    }

    @Override
    def updateSample(String sampleCode, Instant timepoint) throws SampleUpdateException {
        try {
            log.info(String.format("attempting registration of %s at %s", sampleCode, timepoint))
            service.registerSampleStatus(sampleCode, Status.METADATA_REGISTERED, timepoint)
            def updateResponse = new UpdateResponse(sampleCode: sampleCode, updateSuccessful: true)
            log.info(updateResponse)
            output.updateResponse(updateResponse)
        } catch (SampleUpdateException e){
            log.error(e.getMessage(), e)
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
