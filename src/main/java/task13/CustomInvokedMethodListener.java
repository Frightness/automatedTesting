package task13;

import org.apache.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomInvokedMethodListener implements IInvokedMethodListener {

    private static final Logger logger = Logger.getLogger(CustomInvokedMethodListener.class);

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        logger.info("Before invoking method: " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        logger.info("After invoking method: " + method.getTestMethod().getMethodName());
    }
}