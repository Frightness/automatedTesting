package task13;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class CustomTestListener implements ITestListener {

    private static final Logger logger = Logger.getLogger(CustomTestListener.class);
    private WebDriver driver;
    private Process ffmpegProcess;

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getName(), result.getThrowable());

        startRecording();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopRecording();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: " + result.getName() + ", Reason: " + result.getSkipCausedBy());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("Test failed but within success percentage: " + result.getName());
    }

    @Override
    public void onStart(org.testng.ITestContext context) {
        logger.info("Test suite started: " + context.getName());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        logger.info("Test suite finished: " + context.getName());
        if (driver != null) {
            driver.quit();
        }
    }

    private void startRecording() {
        logger.info("Starting video recording");
        try {
            String videoPath = "videos/" + System.currentTimeMillis() + "_test.mp4";

            ffmpegProcess = new ProcessBuilder(
                    "ffmpeg",
                    "-f", "avfoundation",
                    "-framerate", "30",
                    "-i", "1",
                    videoPath
            ).start();

        } catch (IOException e) {
            logger.error("Error starting video recording: " + e.getMessage());
        }
    }

    private void stopRecording() {
        logger.info("Stopping video recording");
        if (ffmpegProcess != null) {
            try {
                ffmpegProcess.destroy();
            } catch (Exception e) {
                logger.error("Error stopping video recording: " + e.getMessage());
            }
        }
    }
}
