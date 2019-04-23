package pastebin.page;

import org.openqa.selenium.WebDriver;

public abstract class PastebinAbstractPage {
    protected WebDriver driver;

    protected PastebinAbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
