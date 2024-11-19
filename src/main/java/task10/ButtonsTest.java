package task10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonsTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testButtons() {
        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        WebElement dynamicClickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));

        Assert.assertTrue(doubleClickButton.isDisplayed(), "Double Click Button error");
        Assert.assertTrue(rightClickButton.isDisplayed(), "Right Click Button error");
        Assert.assertTrue(dynamicClickButton.isDisplayed(), "Dynamic Click Button error");

        Actions actions = new Actions(driver);

        actions.doubleClick(doubleClickButton).perform();
        System.out.println("Double Click completed");

        actions.contextClick(rightClickButton).perform();
        System.out.println("Right Click completed");

        dynamicClickButton.click();
        System.out.println("Dynamic Click completed");

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));

        Assert.assertTrue(doubleClickMessage.isDisplayed(), "Double Click Message error");
        Assert.assertTrue(rightClickMessage.isDisplayed(), "Right Click Message error");
        Assert.assertTrue(dynamicClickMessage.isDisplayed(), "Dynamic Click Message error");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}