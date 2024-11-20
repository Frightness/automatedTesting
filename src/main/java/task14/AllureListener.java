//package task14;
//
//import io.qameta.allure.Attachment;
//import org.openqa.selenium.TakesScreenshot;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.openqa.selenium.OutputType;
//
//public class AllureListener implements ITestListener {
//    @Override
//    public void onTestStart(ITestResult result) {
//        ITestListener.super.onTestStart(result);
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        ITestListener.super.onTestSuccess(result);
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        ITestListener.super.onTestFailure(result);
//        makeScreenShot();
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        ITestListener.super.onTestSkipped(result);
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
//    }
//
//    @Override
//    public void onTestFailedWithTimeout(ITestResult result) {
//        ITestListener.super.onTestFailedWithTimeout(result);
//    }
//
//    @Override
//    public void onStart(ITestContext context) {
//        ITestListener.super.onStart(context);
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        ITestListener.super.onFinish(context);
//    }
//
//    @Attachment(value="Page screen", type="image/png")
//    private byte[] makeScreenShot(){
////        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//    }
//
//}
