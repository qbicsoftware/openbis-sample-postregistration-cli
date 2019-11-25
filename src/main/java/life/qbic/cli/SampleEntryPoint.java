package life.qbic.cli;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Entry point for the Sample command-line Tool application.
 * 
 * The purpose of this class is to act as a bridge between the command line and the <i>real</i> implementation of a tool by using a {@link ToolExecutor}.
 */
public class SampleEntryPoint {

    private static final Logger LOG = LogManager.getLogger(SampleEntryPoint.class);

    /**
     * Main method.
     * 
     * @param args the command-line arguments.
     */
    public static void main(final String[] args) {
        LOG.debug("Starting OpenBIS sample updater tool");
        final ToolExecutor executor = new ToolExecutor();
        executor.invoke(SampleUpdater.class, StatusUpdaterCommand.class, args);
    }
}