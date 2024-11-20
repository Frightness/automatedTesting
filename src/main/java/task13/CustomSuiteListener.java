package task13;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CustomSuiteListener implements ISuiteListener {

    private static final Logger logger = Logger.getLogger(CustomSuiteListener.class);

    @Override
    public void onStart(ISuite suite) {
        logger.info("Test suite started: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        logger.info("Test suite finished: " + suite.getName());
    }
}
