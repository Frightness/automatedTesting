package task12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LabelElement extends Element {
    public LabelElement(WebElement webElement) {
        super(webElement);
    }

    public String getText(){
        System.out.println("getText");
        return webElement.getText();
    }

    public void waitForText(String text) {
        System.out.println("waitForText");
        WebDriverWait wait = new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    public boolean verifyLabelExists() {
        System.out.println("verifyLabelExists");
        return webElement.isDisplayed();
    }
}



//getText - retrieves the text value of a label
//waitForText - waits for a specific text to be present in the label
//verifyLabelExists - verifies if a label exists on the page