package cloud.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CloudPricingPage  extends CloudAbstractPage{
    private static final String XPATH_CALCULATORS_BTN = "//a[text()='Calculators']";

    public CloudPricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CloudFillingCalculationFormPage usePricingCalculator(){
        WebElement calculatorsBtn = waitForElementLocatedBy(driver, By.xpath(XPATH_CALCULATORS_BTN));
        calculatorsBtn.click();
        return new CloudFillingCalculationFormPage(driver);
    }
}
