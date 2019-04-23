package pastebin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage extends PastebinAbstractPage {

    private static final String HOME_URL = "https://pastebin.com/";
    private String locatorForWaitLoadPageById = "paste_code";

    @FindBy(id = ("paste_code"))
    private WebElement inputPasteCodeContent;

    @FindBy(xpath = ("//select[@name='paste_format']"))
    private WebElement dropDownSyntaxHighlighting;

    @FindBy(xpath = ("//select[@name='paste_expire_date']"))
    private WebElement dropDownExpiration;

    @FindBy(name = "paste_name")
    private WebElement inputPasteTitleName;

    @FindBy(id = "submit")
    private WebElement createNewPaste;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOME_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id(locatorForWaitLoadPageById)));
        return this;
    }

    public PastebinHomePage fillNewPasteCode(String pasteCodeContent) {
        inputPasteCodeContent.clear();
        inputPasteCodeContent.sendKeys(pasteCodeContent);
        return this;
    }

    public PastebinHomePage selectSyntaxHighlightingTypeName(String syntaxHighlightingType) {
        Select dropDown = new Select(dropDownSyntaxHighlighting);
        dropDown.selectByVisibleText(syntaxHighlightingType);
        return this;
    }

    public PastebinHomePage selectPasteExpiration(String pasteExpirationInfo) {
        Select dropDown = new Select(dropDownExpiration);
        dropDown.selectByVisibleText(pasteExpirationInfo);
        return this;
    }

    public PastebinHomePage fillPasteTitleName(String pasteTitleName) {
        this.inputPasteTitleName.clear();
        this.inputPasteTitleName.sendKeys(pasteTitleName);
        return this;
    }

    public PastebinNewPastPage createNewPast() {
        createNewPaste.click();
        return new PastebinNewPastPage(driver);
    }
}
