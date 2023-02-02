package com.epam.training.page;

import com.epam.training.browserdriver.BrowserDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.ArrayList;

public abstract class AbstractPage {

    protected WebDriver webDriver;

    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    protected AbstractPage(){
        this.webDriver = BrowserDriver.getWebDriver();;
    }

    public AbstractPage openNewTab() {
        ((JavascriptExecutor) webDriver).executeScript("window.open()");
        return this;
    }

    public AbstractPage switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        return this;
    }

    public AbstractPage switchToDefaultTab(){
        ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(0));
        return this;
    }

    protected abstract AbstractPage openPage();
}
