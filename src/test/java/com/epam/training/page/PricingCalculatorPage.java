package com.epam.training.page;

import com.epam.training.model.DataForPricing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorPage extends AbstractPage{
    private final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//md-tab-item//child::div[text()='Compute Engine']")
    private WebElement computeEngine;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement instancesAmountInput;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystemSelect;
    @FindBy(xpath = "//md-option[@id='select_option_93']//div[contains(text(), 'Free:')]")
    private WebElement operatingSystemFreeDebian;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement provisioningModelSelect;
    @FindBy(xpath = "//md-option[@id='select_option_106']//div[text()='Regular']")
    private WebElement provisioningModelRegular;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.series']")
    private WebElement machineSeriesSelect;
    @FindBy(xpath = "//md-option[@id='select_option_202']//div[contains(text(), 'N1')]")
    private WebElement machineSeriesN1;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineTypeSelect;
    @FindBy(xpath = "//md-option[@id='select_option_429']//div[contains(text(), 'n1-standard-8')]")
    private WebElement machineTypeN1Standard8;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']//div[contains(text(), 'Add GPU')]")
    private WebElement addGPUCheckbox;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuTypeSelect;
    @FindBy(xpath = "//md-option[@id='select_option_474']//div[contains(text(), 'NVIDIA Tesla V100')]")
    private WebElement gpuTypeNVIDIATeslaV100;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberGPUsSelect;
    @FindBy(xpath = "//md-option[@id='select_option_478']//div[contains(text(), '1')]")
    private WebElement numberGPUs1;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDsSelect;
    @FindBy(xpath = "//md-option[@id='select_option_450']//div[contains(text(), '2x375 G')]")
    private WebElement localSSDs2x375GB;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement locationSelect;
    @FindBy(xpath = "//md-option[@id='select_option_229']//div[contains(text(), 'Frankfurt')]")
    private WebElement locationFrankfurt;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsageSelect;
    @FindBy(xpath = "//md-option[@id='select_option_129']//div[contains(text(), '1 Year')]")
    private WebElement committedUsage1Year;
    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateButton;

    public PricingCalculatorPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    protected AbstractPage openPage() {
        webDriver.navigate().to(HOMEPAGE_URL);
        return this;
    }

    public PricingCalculatorPage fillPricingCalculatorForm(DataForPricing dataForPricing){

        WebElement outerFrame = webDriver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe"));
        webDriver.switchTo().frame(outerFrame);
        WebElement iframe = webDriver.findElement(By.id("myFrame"));
        webDriver.switchTo().frame(iframe);

        computeEngine.click();
        instancesAmountInput.sendKeys(dataForPricing.getMachinesAmount());
        selectOperatingSystem();
        operatingSystemFreeDebian.click();
        selectProvisioningModel();
        provisioningModelRegular.click();
        selectMachineSeries();
        machineSeriesN1.click();
        selectMachineType();
        machineTypeN1Standard8.click();
        addGPUCheckbox.click();
        selectGPUsType();
        gpuTypeNVIDIATeslaV100.click();
        selectGPUsNumber();
        numberGPUs1.click();
        selectLocalSSDs();
        localSSDs2x375GB.click();
        selectLocation();
        locationFrankfurt.click();
        selectCommittedUsage();
        committedUsage1Year.click();

        return this;
    }

    public CalculationResultsPage openCalculationResultsPage(){
        addToEstimateButton.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//md-content[@ng-if='cloudCartCtrl.showComputeItems']//md-list-item")));
        return new CalculationResultsPage(webDriver);
    }
    public void selectMachineSeries(){
        machineSeriesSelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(machineSeriesSelect, "aria-expanded", "true"));
    }
    public void selectProvisioningModel(){
        provisioningModelSelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(provisioningModelSelect, "aria-expanded", "true"));
    }
    public void selectOperatingSystem(){
        operatingSystemSelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(operatingSystemSelect, "aria-expanded", "true"));
    }
    public void selectMachineType(){
        machineTypeSelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(machineTypeSelect, "aria-expanded", "true"));
    }
    public void selectGPUsType(){
        gpuTypeSelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(gpuTypeSelect, "aria-expanded", "true"));
    }
    public void selectGPUsNumber(){
        numberGPUsSelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(numberGPUsSelect, "aria-expanded", "true"));
    }
    public void selectLocalSSDs(){
        localSSDsSelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(localSSDsSelect, "aria-expanded", "true"));
    }
    public void selectLocation(){
        locationSelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(locationSelect, "aria-expanded", "true"));
    }
    public void selectCommittedUsage(){
        committedUsageSelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(committedUsageSelect, "aria-expanded", "true"));
    }
}
