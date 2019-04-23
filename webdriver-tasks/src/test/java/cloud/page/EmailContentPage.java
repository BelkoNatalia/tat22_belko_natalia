package cloud.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailContentPage extends CloudAbstractPage{

    private static final String XPATH_COST_IN_EMAIL_FIELD = "//h3[text() = 'Total Estimated Monthly Cost']/following::h3";
    private static final String ID_Iframe = "mess_frame";

    public EmailContentPage(WebDriver driver) {
        super(driver);
    }

    public String getTotalEstimateCost(){
       WebElement iFrame = waitForElementLocatedBy(driver, By.id(ID_Iframe));
       driver.switchTo().frame(iFrame);
       return waitForElementLocatedBy(driver, By.xpath(XPATH_COST_IN_EMAIL_FIELD)).getText();
    }
}
