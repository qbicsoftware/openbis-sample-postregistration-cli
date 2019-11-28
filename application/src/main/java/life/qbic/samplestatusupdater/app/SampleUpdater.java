package life.qbic.samplestatusupdater.app;

import life.qbic.cli.QBiCTool;
import life.qbic.datamodel.services.Address;
import life.qbic.datamodel.services.Location;
import cli.ParseProperties;
import cli.SampleSearchPresenter;
import life.qbic.samplestatusupdater.search.OpenBisSearch;
import life.qbic.samplestatusupdater.search.SampleSearchConnector;
import life.qbic.samplestatusupdater.search.FindNewOpenBisSamples;
import life.qbic.samplestatusupdater.search.SampleSearchConnector;
import life.qbic.samplestatusupdater.serviceconnectors.OpenBisSession;
import life.qbic.samplestatusupdater.serviceconnectors.SampleTrackingConnector;
import life.qbic.samplestatusupdater.serviceconnectors.ServiceSearch;
import life.qbic.samplestatusupdater.serviceconnectors.ServiceUserCredentials;
import life.qbic.services.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Implementation of Sample command-line Tool. Its command-line arguments are contained in instances of {@link StatusUpdaterCommand}.
 */
public class SampleUpdater extends QBiCTool<StatusUpdaterCommand> {

    private static final Logger LOG = LogManager.getLogger(SampleUpdater.class);

    /**
     * Constructor.
     *
     * @param command an object that represents the parsed command-line arguments.
     */
    public SampleUpdater(final StatusUpdaterCommand command) {
        super(command);
    }

    @Override
    public void execute() {
        // get the parsed command-line arguments
        final StatusUpdaterCommand command = super.getCommand();

        Map properties = (Map) new ParseProperties(command.config).parse();
        OpenBisSession session = new OpenBisSession(
                                        (String) properties.get("openbisAsUrl"),
                                        (String) properties.get("openbisUser"),
                                        (String) properties.get("openbisPw"));
        ServiceUserCredentials credentials = new ServiceUserCredentials(
                                                    (String) properties.get("serviceUser"),
                                                    (String) properties.get("serviceUserPw"));
        URL serviceRegistry = createUrlFromString((String) properties.get("serviceRegistryUrl"));
        List<Service> serviceList = ServiceSearch.findSampleTrackingService(serviceRegistry);

        if (serviceList.isEmpty()) {
            LOG.error("Could not find any services for sample tracking!");
            System.exit(1);
        } else {
            LOG.info("Found at least one sample tracking service.");
        }

        SampleTrackingConnector connector = new SampleTrackingConnector(serviceList.get(0), credentials);

        OpenBisSearch search = new SampleSearchConnector(session.getApi(), session.getToken());
        Date lastSearchDate = parseDateFromStringWithPattern((String) properties.get("lastSearchDate"), "yyyy-MM-dd");

        SampleSearchPresenter presenter = new SampleSearchPresenter();

        final FindNewOpenBisSamples findNewOpenBisSamples = new FindNewOpenBisSamples(search, presenter);
        findNewOpenBisSamples.searchNewSamplesSince(lastSearchDate);

    }

    URL createUrlFromString(String urlString){
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            LOG.error("URL for service registry was malformatted.", e);
        }
        return url;
    }

    Date parseDateFromStringWithPattern(String date, String pattern){
        Date lastSearchDate = null;
        try {
            lastSearchDate = new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException e) {
            LOG.error("Could not parse date from date String " + date);
        }
        return lastSearchDate;
    }

    Location createQBiCLocation(){
        Location location = new Location();
        Address address = new Address();
        address.setStreet("Auf der Morgenstelle 10");

        location.address(address);
        location.arrivalDate(new Date());
        location.name("QBiC DataStore");
        location.responsiblePerson("QBiC team");
        location.responsibleEmail("support@qbic.zendesk.com");

        return location;
    }

    // TODO: override the shutdown() method if you are implementing a daemon and want to take advantage of a shutdown hook for clean-up tasks
}