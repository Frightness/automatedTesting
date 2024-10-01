package task10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task10Test {
    public static void main(String[] args) {
        WebDriver driver;
        @BeforeTest
        void setUp() {
            ChromeDriverManager.getInstance().setup;
            System.setProperty("webdriver.chrome.driver",
                    "driver/chromedriver");

            driver = new ChromeDriver();
        }


    }
}