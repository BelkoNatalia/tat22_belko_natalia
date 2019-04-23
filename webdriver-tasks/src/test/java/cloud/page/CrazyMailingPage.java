package cloud.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CrazyMailingPage extends CloudAbstractPage{

    private static final String ID_TEMPORARY_EMAIL_FIELD = "email_addr";
    private static final String TEMPLATE_XPATH_SUBJECT_CLOUD_EMAIL = "//strong[contains(text(),'%s')]";

    public CrazyMailingPage(WebDriver driver) {
        super(driver);
    }
    public String getEmail(){
        WebElement email = waitForElementLocatedBy(driver, By.id(ID_TEMPORARY_EMAIL_FIELD));
        return email.getText();
    }

    public EmailContentPage openEmailBySubject(String emailSubject){
        String xpathSubject = String.format(TEMPLATE_XPATH_SUBJECT_CLOUD_EMAIL, emailSubject);
        waitForElementToBeClickableBy(driver, By.xpath(xpathSubject)).click();
        return new EmailContentPage(driver);
    }
}
