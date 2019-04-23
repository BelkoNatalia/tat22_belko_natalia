package cloud.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import cloud.page.CloudCalkulationResultPage;
import cloud.page.CloudHomePage;
import cloud.page.CrazyMailingPage;
import cloud.page.EmailYourEstimatePage;

public class CloudTestRun {
    private WebDriver driver;
    private static final String TEMPLATE_DATA = "VM class:'%s'," +
                                                "Instance type:'%s'," +
                                                "Total available local SSD:'%s'," +
                                                "Region:'%s',Commitment term:'%s'" +
                                                "Total Estimated Cost:'%s'";
    private static final int NUMBER_OF_INSTANCES = 4;
    private static final String OPERATING_SYSTEM_SOFTWARE = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private static final String VM_CLASS = "Regular";
    private static final String INSTANCE_TYPE = "n1-standard-8(vCPUs: 8, RAM: 30 GB)";
    private static final int NUMBER_OF_GPUS = 1;
    private static final String GPU_TYPE = "NVIDIA Tesla V100";
    private static final String LOCAL_SSD = "2x375 GB";
    private static final String DATACENTER_LOCATION = "Frankfurt (europe-west3)";
    private static final String COMMITED_USAGE = "1 Year";
    private static final String ESTIMATED_COST = "USD 1,187.77 per 1 month";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Filling form check data and check rent estimation")
    public void checkValuesAfterFillInstanceBlock() {

        CloudHomePage cloudHomePage = new CloudHomePage(driver);

        cloudHomePage.openPage()
                .seeAllProducts()
                .seePricing()
                .usePricingCalculator()
                .activateComputeEngine()
                .fillNumberOfInstances(NUMBER_OF_INSTANCES)
                .chooseOperatingSystem(OPERATING_SYSTEM_SOFTWARE)
                .chooseVmClass()
                .chooseInstanceType()
                .pickGPUs()
                .chooseNumberOfGPUs(NUMBER_OF_GPUS)
                .chooseGPuType(GPU_TYPE)
                .chooseLocalSsd(LOCAL_SSD)
                .chooseDatacenterLocation(DATACENTER_LOCATION)
                .chooseCommittedUsage(COMMITED_USAGE)
                .getEstimation();

        CloudCalkulationResultPage cloudCalkulationResultPage = new CloudCalkulationResultPage(driver);

        String vmClassByPage = cloudCalkulationResultPage.getVmClass();
        String instanceTypeByPage = cloudCalkulationResultPage.getInstanceType();
        String localSsdByPage = cloudCalkulationResultPage.getLocalSsd();
        String datacenterLocationByPage = cloudCalkulationResultPage.getRegion();
        String commitedUsageByPage = cloudCalkulationResultPage.getCommitmentTerm();
        String estimatedCostByPage = cloudCalkulationResultPage.getTotalEstimatedCost();

        String expectedVmClass = VM_CLASS.toLowerCase().trim();

        String[] expectedInstanceTypeArray = INSTANCE_TYPE.split("\\(");
        String expectedInstanceTypeValue = expectedInstanceTypeArray[0].trim();

        String[] expectedDatacenterLocationArray = DATACENTER_LOCATION.split("\\(");
        String expectedDatacenterLocationValue = expectedDatacenterLocationArray[0].trim();

        String[] vmClassArray = vmClassByPage.split(":");
        String actualVmClassValue = vmClassArray[1].trim();

        String[] instanceTypeArray = instanceTypeByPage.split(":");
        String actualInstanceTypeValue = instanceTypeArray[1].trim();

        String[] localSsdArray = localSsdByPage.split("space");
        String actualLocalSsdValue = localSsdArray[1].trim();

        String[] datacenterLocationArray = datacenterLocationByPage.split(":");
        String actualDatacenterLocationValue = datacenterLocationArray[1].trim();

        String[] commitedUsageArray = commitedUsageByPage.split(":");
        String actualCommitedUsageValue = commitedUsageArray[1].trim();

        String[] estimatedCostArray = estimatedCostByPage.split(":");
        String actualEstimatedCostValue = estimatedCostArray[1].trim();

        String actualData = String.format(TEMPLATE_DATA, actualVmClassValue, actualInstanceTypeValue, actualLocalSsdValue,
                actualDatacenterLocationValue, actualCommitedUsageValue, actualEstimatedCostValue);

        String expectedData = String.format(TEMPLATE_DATA, expectedVmClass, expectedInstanceTypeValue, LOCAL_SSD,
                expectedDatacenterLocationValue, COMMITED_USAGE, ESTIMATED_COST);

        Assert.assertEquals(expectedData, actualData);
    }

    @Test(description = "Filling form correct amount of the order by email")
    public void checkTheCorrectAmountOfTheOrderByEmail () {

        String emailSubject = "Google Cloud Platform Price Estimate";
        String temporaryMail = "https://www.crazymailing.com";

        CloudHomePage cloudHomePage = new CloudHomePage(driver);

        cloudHomePage.openPage()
                .seeAllProducts()
                .seePricing()
                .usePricingCalculator()
                .activateComputeEngine()
                .fillNumberOfInstances(NUMBER_OF_INSTANCES)
                .chooseOperatingSystem(OPERATING_SYSTEM_SOFTWARE)
                .chooseVmClass()
                .chooseInstanceType()
                .pickGPUs()
                .chooseNumberOfGPUs(NUMBER_OF_GPUS)
                .chooseGPuType(GPU_TYPE)
                .chooseLocalSsd(LOCAL_SSD)
                .chooseDatacenterLocation(DATACENTER_LOCATION)
                .chooseCommittedUsage(COMMITED_USAGE)
                .getEstimation();

        CloudCalkulationResultPage cloudCalkulationResultPage = new CloudCalkulationResultPage(driver);

        String estimatedCostByPage = cloudCalkulationResultPage.getTotalEstimatedCost();

        EmailYourEstimatePage emailYourEstimatePage =cloudCalkulationResultPage.chooseEmailEstimate();

        String emailEstimateWindowHandle = emailYourEstimatePage.getCurrentWindowHandle();
        emailYourEstimatePage.openNewTabWithUrl(temporaryMail);

        CrazyMailingPage crazyMailingPage = new CrazyMailingPage(driver);
        String emailAddress = crazyMailingPage.getEmail();
        String crazyMailingWindowHandle = crazyMailingPage.getCurrentWindowHandle();
        crazyMailingPage.goToTabByWindowHandle(emailEstimateWindowHandle);

        new EmailYourEstimatePage(driver).fillEmailField(emailAddress)
                .sendEmail()
                .goToTabByWindowHandle(crazyMailingWindowHandle);

        String totalEstimateCostFromEmail = crazyMailingPage.openEmailBySubject(emailSubject)
                        .getTotalEstimateCost().trim();

        String[] estimatedCostArray = estimatedCostByPage.split(":");
        String expectedEstimatedCostValue = estimatedCostArray[1].replaceAll("per 1 month","").trim();

        Assert.assertEquals(expectedEstimatedCostValue, totalEstimateCostFromEmail);
    }

    @AfterMethod(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
