package cloud.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloudProductsAndServicesPage extends CloudAbstractPage{
    private static final String XPATH_SEE_PRICING_BTN = "//a[contains(text(),'See Pricing')]";

    public CloudProductsAndServicesPage(WebDriver driver) {
        super(driver);
    }

    public CloudPricingPage seePricing(){
        WebElement seePricingBtn = waitForElementLocatedBy(driver, By.xpath(XPATH_SEE_PRICING_BTN));
        seePricingBtn.click();
        return new CloudPricingPage(driver);
    }
}
