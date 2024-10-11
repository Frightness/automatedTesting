package task12;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Task12 {
    @Test
    void LabelTest() {
        new BBC_BO().openUSElectionTab().verifyElectionTitle();
    }

    @AfterTest
    void closeBrowser() {
        DriverProvider.INSTANCE.getDriver().close();
    }

    //General
    //Implement PageFactory for a few pages.
    //Implement Wrapper for common WebElements (choose your variant).
    //Implement methods for your web element with console logging. (Choose your variant with specific methods)
    //Use those methods in simple TC scenario

    //Labels:
    //getText - retrieves the text value of a label
    //waitForText - waits for a specific text to be present in the label
    //verifyLabelExists - verifies if a label exists on the page



}
