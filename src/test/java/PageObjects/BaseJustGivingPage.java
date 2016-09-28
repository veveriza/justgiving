package PageObjects;

import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by vpuscas on 28/09/2016.
 */
public interface BaseJustGivingPage {

    ExpectedCondition getPageLoadCondition();

    String getPageUrl();
}
