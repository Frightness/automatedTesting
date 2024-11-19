package task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class Task11 {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Test
    public void testRegistration() {
        driver.get("https://cinemly.vercel.app/auth");

        WebElement createAccountLink = driver.findElement(By.xpath("//p[text()='Create an account']"));
        createAccountLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("usernameForm")));

        WebElement usernameField = driver.findElement(By.className("usernameForm"));
        WebElement emailField = driver.findElement(By.className("emailForm"));
        WebElement passwordField = driver.findElement(By.className("passForm"));
        WebElement confirmPasswordField = driver.findElement(By.className("confirmPassForm"));
        WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Register']"));

        usernameField.sendKeys("SmthExample11");
        emailField.sendKeys("blablae@example.com");
        passwordField.sendKeys("StrongPassword123");
        confirmPasswordField.sendKeys("StrongPassword123");

        signUpButton.click();

        wait.until(ExpectedConditions.urlToBe("https://cinemly.vercel.app/profile"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://cinemly.vercel.app/profile", "Redirect to /profile failed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}