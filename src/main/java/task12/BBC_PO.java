package task12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BBC_PO {
    public BBC_PO(String url) {
        DriverProvider.INSTANCE.getDriver().get(url);
        PageFactory.initElements(new FillDecorator(DriverProvider.INSTANCE.getDriver()), this);
    }

    public WebElement getUSElectionTab() {
        return USElectionTab;
    }

    public LabelElement getUSElectionTitle() {
        return USElectionTitle;
    }

    @FindBy(linkText = "US Election")
    WebElement USElectionTab;

    @FindBy(xpath = "//*[.='US election 2024']")
    LabelElement USElectionTitle;


}
