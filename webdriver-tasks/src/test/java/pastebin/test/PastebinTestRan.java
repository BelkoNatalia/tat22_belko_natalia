package pastebin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastebin.page.PastebinHomePage;
import pastebin.page.PastebinNewPastPage;

public class PastebinTestRan {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "New Paste is crated")
    public void newPastIsCreated() {
        String pasteCode = "Hello from WebDriver";
        String pasteExpirationInfo = "10 Minutes";
        String pasteTitleName = "helloweb";

        new PastebinHomePage(driver)
                .openPage()
                .fillNewPasteCode(pasteCode)
                .selectPasteExpiration(pasteExpirationInfo)
                .fillPasteTitleName(pasteTitleName)
                .createNewPast();
    }

    @Test(description = "Create paste and check parameters (title, syntax, content)")
    public void createNewPastebinAndCheckTitleHighlightingTypeCodeContent() {
        String pasteCodeContent = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String syntaxHighlightingType = "Bash";
        String pasteExpirationInfo = "10 Minutes";
        String pasteTitleName = "how to gain dominance among developers";

        PastebinNewPastPage pastebinNewPastPage = new PastebinHomePage(driver)
                .openPage()
                .fillNewPasteCode(pasteCodeContent)
                .selectSyntaxHighlightingTypeName(syntaxHighlightingType)
                .selectPasteExpiration(pasteExpirationInfo)
                .fillPasteTitleName(pasteTitleName)
                .createNewPast();

        String templateData = "Code content:'%s',\nSyntax highlighting type:'%s',\nTitle name:'%s'";

        String expectedData = String.format(templateData, pasteCodeContent, syntaxHighlightingType, pasteTitleName);

        String pasteCodeContentByPage = pastebinNewPastPage.getExpectedCodeContent();
        String syntaxHighlightingTypeByPage = pastebinNewPastPage.getHighlightingType();
        String pasteTitleNameByPage = pastebinNewPastPage.getPageTitleNameText();

        String actualData = String.format(templateData, pasteCodeContentByPage, syntaxHighlightingTypeByPage,
                pasteTitleNameByPage);

        Assert.assertEquals(expectedData, actualData);
    }

    @AfterMethod(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }

}
