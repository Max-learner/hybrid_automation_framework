package com.epam.training.test;

import com.epam.training.browserdriver.BrowserDriver;
import com.epam.training.model.VirtualMachineData;
import com.epam.training.model.EmailAddress;
import com.epam.training.model.SearchQuery;
import com.epam.training.page.CalculationResultsPage;
import com.epam.training.page.EmailServicePage;
import com.epam.training.page.EmailYourEstimatePage;
import com.epam.training.page.PricingCalculatorPage;
import com.epam.training.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;


@Listeners({TestListener.class})
public class TestEnvironmentSetup {

    protected WebDriver webDriver;

    protected SearchQuery newSearchQuery;
    protected PricingCalculatorPage pricingCalculatorPage;
    protected VirtualMachineData virtualMachineDataForPricing;
    protected CalculationResultsPage calculationResultsPage;
    protected EmailYourEstimatePage emailYourEstimatePage;
    protected EmailAddress emailAddress;
    protected EmailServicePage emailServicePage;

    @BeforeClass(alwaysRun = true, description = "Open browser according to properties and setup")
    public void openAndSetupBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        webDriver = BrowserDriver.getWebDriver();
        webDriver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true, description = "Close browser and clear webdriver")
    public  void closeBrowser(){
        BrowserDriver.closeWebdriver();
    }
}
