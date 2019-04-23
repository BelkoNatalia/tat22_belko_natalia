package cloud.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudCalkulationResultPage extends CloudAbstractPage {

    private static final String XPATH_INSTANCE_TYPE_ROW = "//div[contains(text(), 'Instance type:')]";

    @FindBy(xpath = "//div[contains(text(), 'VM class:')]")
    private WebElement vmClassRow;

    @FindBy(xpath = "//div[contains(text(), 'Region:')]")
    private WebElement regionRow;

    @FindBy(xpath = "//div[contains(text(), 'Total available local SSD space')]")
    private WebElement localSsdRow;

    @FindBy(xpath = "//div[contains(text(), 'Commitment term:')]")
    private WebElement commitmentTermRow;

    @FindBy(xpath = "//b[contains(text(), 'Total Estimated Cost:')]")
    private WebElement totalEstimatedCostRow;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement emailEstimateBtn;

    public CloudCalkulationResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getVmClass() {
        return vmClassRow.getText();
    }

    public String getInstanceType() {
        return waitForElementLocatedBy(driver, By.xpath(XPATH_INSTANCE_TYPE_ROW)).getText();
    }

    public String getRegion() {
        return regionRow.getText();
    }

    public String getLocalSsd() {
        return localSsdRow.getText();
    }

    public String getCommitmentTerm() {
        return commitmentTermRow.getText();
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCostRow.getText();
    }

    public EmailYourEstimatePage chooseEmailEstimate(){
        emailEstimateBtn.click();
        return new EmailYourEstimatePage(driver);
    }

}
