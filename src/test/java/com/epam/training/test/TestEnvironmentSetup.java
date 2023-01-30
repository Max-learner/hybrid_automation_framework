package com.epam.training.test;

import com.epam.training.browserdriver.BrowserDriver;
import com.epam.training.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class TestEnvironmentSetup {
    protected WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void openAndSetupBrowser(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        webDriver = BrowserDriver.getWebDriver();
//        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public  void closeBrowser(){
        BrowserDriver.closeWebdriver();
//        webDriver.quit();
//        webDriver = null;
    }
}
