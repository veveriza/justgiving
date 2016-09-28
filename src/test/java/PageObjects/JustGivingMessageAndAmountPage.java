package PageObjects;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class JustGivingMessageAndAmountPage implements BaseJustGivingPage {
    private final Browser driver;
    public JustGivingMessageAndAmountPage(Browser driver) {
        this.driver = driver;
    }

    @FindBy(id = "MessageAndAmount-fieldset")
    WebElement fieldSet;

    @FindBy(id = "MessageAndAmount_Message")
    WebElement leaveAMessage;

    @FindBy(id = "MessageAndAmount_Name")
    WebElement yourName;

    @FindBy(xpath = "//a[contains(@class,'awesome-continue-button ')]")
    WebElement continueButton;

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(fieldSet);
    }

    @Override
    public String getPageUrl() {
        return "/4w350m3/donation/direct/charity/2050#MessageAndAmount";
    }

    public JustGivingMessageAndAmountPage open() {
        return driver.open(JustGivingMessageAndAmountPage.class);
    }

    public void leaveMessage() {
        leaveAMessage.sendKeys(RandomStringUtils.randomAlphanumeric(20));
    }

    public void enterYourName() {
        yourName.sendKeys(RandomStringUtils.randomAlphanumeric(20));
    }

    public JustGivingIdentity clickContinue() {
        driver.waitForElementToBeVisible(continueButton);
        continueButton.click();
        JustGivingIdentity justGivingIdentity = driver.init(JustGivingIdentity.class);
        driver.waitForPageToLoad(justGivingIdentity.getPageLoadCondition());
        return justGivingIdentity;
    }

    public void fillTheInfo(){
        leaveMessage();
        enterYourName();
    }


}

