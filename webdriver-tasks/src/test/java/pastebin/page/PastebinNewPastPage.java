package pastebin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinNewPastPage {
    private WebDriver driver;

    @FindBy(id = "success")
    private WebElement checkNote;

    @FindBy(xpath = "//div[@class = 'paste_box_line1']")
    private WebElement pageTitleName;

    @FindBy(xpath = "//span[@class ='h_640']/a")
    private WebElement syntaxHighlightingLabel;

    @FindBy(tagName = "textarea")
    private WebElement codeContentArea;

    public PastebinNewPastPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getExpectedCodeContent() {
        return codeContentArea.getText();
    }

    public String getHighlightingType() {
        return syntaxHighlightingLabel.getText();
    }

    public String getPageTitleNameText() {
        return pageTitleName.getAttribute("title");
    }
}
