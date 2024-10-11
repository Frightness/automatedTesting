package task12;

import org.testng.Assert;

public class BBC_BO {
    BBC_PO homePage;

    public BBC_BO openUSElectionTab() {
        homePage = new BBC_PO("https://www.bbc.com");
        homePage.getUSElectionTab().click();
        return this;
    }

    public BBC_BO verifyElectionTitle() {
        homePage.getUSElectionTitle().getText();
        homePage.getUSElectionTitle().waitForText("US election 2024");
        homePage.getUSElectionTitle().verifyLabelExists();


        Assert.assertTrue(homePage.getUSElectionTitle().verifyLabelExists());
        return this;
    }
}
