package cloud.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloudHomePage extends CloudAbstractPage{

    private static final String HOME_URL = "https://cloud.google.com/";

    private static final String XPATH_SEE_ALL_PRODUCTS_BTN = "//a[contains(text(),'See products')]";

    public CloudHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudHomePage openPage() {
        driver.get(HOME_URL);
        return this;
    }

    public CloudProductsAndServicesPage seeAllProducts(){
        WebElement seeAllProductsBtn = waitForElementLocatedBy(driver,By.xpath(XPATH_SEE_ALL_PRODUCTS_BTN));
        seeAllProductsBtn.click();
        return new CloudProductsAndServicesPage(driver);
    }
}