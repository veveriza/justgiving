package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by vpuscas on 28/09/2016.
 */
public class Browser {


    private final WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public <T  extends BaseJustGivingPage> T init(Class<T> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }

    public <T  extends BaseJustGivingPage> T open(Class<T> pageClass) {
        return null;
    }

    public void waitForPageToLoad(ExpectedCondition<?> pageLoadCondition) {

    }

    public void waitForElementToBeVisible(WebElement element){

    }

}
