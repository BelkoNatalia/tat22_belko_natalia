package cloud.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailYourEstimatePage extends CloudAbstractPage {

    private static final String XPATH_SEND_EMAIL_BTN = "//button[contains(text(),'Send Email') and not(@disabled)]";
    private static final String XPATH_EMAIL_FIELD = "//label[contains(text(),'Email')]/following-sibling::input";
    private static final String ID_Iframe = "idIframe";

    public EmailYourEstimatePage(WebDriver driver) {
        super(driver);
    }

    public EmailYourEstimatePage fillEmailField(String email) {
        WebElement iFrame = waitForElementLocatedBy(driver, By.id(ID_Iframe));
        driver.switchTo().frame(iFrame);
        waitForElementLocatedBy(driver, By.xpath(XPATH_EMAIL_FIELD)).sendKeys(email);
        return this;
    }

    public CloudCalkulationResultPage sendEmail() {
        waitForElementToBeClickableBy(driver, By.xpath(XPATH_SEND_EMAIL_BTN)).click();
        return new CloudCalkulationResultPage(driver);
    }


}
