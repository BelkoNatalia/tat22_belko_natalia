package cloud.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudFillingCalculationFormPage extends CloudAbstractPage {

    private static final String TEMPLATE_XPATH_OPERATING_SYSTEM_OPTION = "//md-option/div[contains(text(),'%s')]";
    private static final String ID_VM_CLASS = "select_option_63";
    private static final String ID_INSTANCE_TYPE = "select_option_73";
    private static final String XPATH_ESTIMATE_BTN = "//form[@name='ComputeEngineForm']" +
            "//button[@class ='md-raised md-primary cpc-button md-button md-ink-ripple' ]";
    private static final String TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU = "//div[contains(@style,'display: block;')]//div[text()='%s']";
    private static final String ID_Iframe = "idIframe";
    private static final String XPATH_GPUS_CHECK_BOX = "//div[contains(text(),'Add GPUs.')]/preceding-sibling::div";
    private static final String ID_LOCAL_SSD_FIELD = "select_value_label_46";
    private static final String XPATH_WAIT_CLOSE_MENU = "//md-select[@aria-expanded='true']";

    @FindBy(id = "idIframe")
    private WebElement iframe;

    @FindBy(xpath = "//md-tab-item//div[text()='Compute Engine' ]")
    private WebElement computeEngineBtn;

    @FindBy(id = "input_49")
    private WebElement numberOfInstancesInput;

    @FindBy(id = "select_value_label_43")
    private WebElement operatingSystemSoftwareField;

    @FindBy(id = "select_value_label_44")
    private WebElement vmClassField;

    @FindBy(id = "select_value_label_45")
    private WebElement instanceTypeField;

    @FindBy(id = "select_value_label_330")
    private WebElement numberOfGPUsField;

    @FindBy(id = "select_value_label_331")
    private WebElement GPuTypeField;

    @FindBy(id = "select_value_label_47")
    private WebElement datacenterLocationField;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Committed usage']")
    private WebElement commitedUsageField;

    public CloudFillingCalculationFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CloudFillingCalculationFormPage activateComputeEngine() {
        waitForElementLocatedBy(driver, By.id(ID_Iframe));
        driver.switchTo().frame(iframe);
        computeEngineBtn.click();
        return this;
    }

    public CloudFillingCalculationFormPage fillNumberOfInstances(int numberOfInstances) {
        numberOfInstancesInput.sendKeys(String.valueOf(numberOfInstances));
        return this;
    }

    public CloudFillingCalculationFormPage chooseOperatingSystem(String operatingSystemSoftware) {
        String xpathOperatingSystem = String.format(TEMPLATE_XPATH_OPERATING_SYSTEM_OPTION, operatingSystemSoftware);
        operatingSystemSoftwareField.click();
        WebElement operatingSystemOption = waitForElementLocatedBy(driver, By.xpath(xpathOperatingSystem));
        operatingSystemOption.click();
        return this;
    }

    public CloudFillingCalculationFormPage chooseVmClass() {
        vmClassField.click();
        waitForElementLocatedBy(driver, By.id(ID_VM_CLASS)).click();
        return this;
    }

    public CloudFillingCalculationFormPage chooseInstanceType(){
        instanceTypeField.click();
        waitForElementToBeClickableBy(driver, By.id(ID_INSTANCE_TYPE)).click();
        return this;
    }

    public CloudFillingCalculationFormPage pickGPUs() {
        WebElement gpusCheckBox = waitForElementToBeClickableBy(driver, By.xpath(XPATH_GPUS_CHECK_BOX));
        if (!gpusCheckBox.isSelected()) {
            gpusCheckBox.click();
        }
        return this;
    }

    public CloudFillingCalculationFormPage chooseNumberOfGPUs(int numberOfGpus){
        String xpathNumberOfGPUs = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, numberOfGpus);
        numberOfGPUsField.click();
        WebElement element = waitForElementToBeClickableBy(driver, By.xpath(xpathNumberOfGPUs));
        element.click();
        return this;
    }

    public CloudFillingCalculationFormPage chooseGPuType(String gpuType) {
        String xpathGPuTyp = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, gpuType);
        GPuTypeField.click();
        waitForElementLocatedBy(driver, By.xpath(xpathGPuTyp)).click();
        return this;
    }

    public CloudFillingCalculationFormPage chooseLocalSsd(String localSsd) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(XPATH_ESTIMATE_BTN)));
        String xpathLocalSsd = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, localSsd);
        WebElement localSsdField = waitForElementToBeClickableBy(driver, By.id(ID_LOCAL_SSD_FIELD));

        waitInvisibilityOfElementLocated(driver, By.xpath(XPATH_WAIT_CLOSE_MENU));

        localSsdField.click();
        waitForElementToBeClickableBy(driver, By.xpath(xpathLocalSsd)).click();
        return this;
    }

    public CloudFillingCalculationFormPage chooseDatacenterLocation(String datacenterLocation) {
        String xpathDatacenterLocation = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, datacenterLocation);
        datacenterLocationField.click();
        waitForElementToBeClickableBy(driver, By.xpath(xpathDatacenterLocation)).click();
        return this;
    }

    public CloudFillingCalculationFormPage chooseCommittedUsage(String committedUsage) {
        String xpathCommittedUsage = String.format(TEMPLATE_XPATH_ITEM_DROP_DOWN_MENU, committedUsage);
        commitedUsageField.click();
        waitForElementToBeClickableBy(driver, By.xpath(xpathCommittedUsage)).click();
        return this;
    }

    public CloudCalkulationResultPage getEstimation() {
        waitForElementLocatedBy(driver, By.xpath(XPATH_ESTIMATE_BTN)).click();
        return new CloudCalkulationResultPage(driver);
    }

}
