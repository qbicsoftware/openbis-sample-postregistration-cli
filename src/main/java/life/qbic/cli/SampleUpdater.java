package life.qbic.cli;


import life.qbic.openbis.OpenBisSession;
import life.qbic.openbis.SampleSearch;
import life.qbic.sampletracking.usecases.FindNewOpenBisSamples;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        SampleSearch search = new SampleSearch(session.getApi(), session.getToken());
        Date lastSearchDate = parseDateFromStringWithPattern((String) properties.get("lastSearchDate"), "yyyy-MM-dd");
        FindNewOpenBisSamples findNewOpenBisSamples = new FindNewOpenBisSamples(lastSearchDate, search);
        List result = findNewOpenBisSamples.findNewOpenBisSamples();
        result.forEach( System.out::println );

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

    // TODO: override the shutdown() method if you are implementing a daemon and want to take advantage of a shutdown hook for clean-up tasks
}