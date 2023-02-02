package com.epam.training.page;

import com.epam.training.model.VirtualMachineData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingCalculatorPage extends AbstractPage{
    private final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator";

    private final String COMMON_OPTION_XPATH = "//md-select-menu//div[contains(text(), '%s')]";
    private final String GPU_NUMBER_OPTION_XPATH = "//md-option[contains(@ng-repeat, 'GpuNumbers')]//div[contains(text(), '%s')]";
    private final String LOCAL_SSD_OPTION_XPATH = "//md-option[contains(@ng-repeat, 'dynamicSsd')]//div[contains(text(), '%s')]";
    private final String LOCATION_OPTION_XPATH = "//md-option[contains(@ng-repeat, 'inputRegionText.computeServer')]//div[contains(text(), '%s')]";
    private final String COMMITED_USAGE_OPTION_XPATH = "//div[contains(@class, 'cpc-region-select')]/following-sibling::div//div[contains(text(), '%s')]";

    @FindBy(xpath = "//md-tab-item//div[@title='Compute Engine']")
    private WebElement computeEngine;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement instancesAmountInput;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystemSelect;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement provisioningModelSelect;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.series']")
    private WebElement machineSeriesSelect;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineTypeSelect;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']//div[contains(text(), 'Add GPU')]")
    private WebElement addGPUCheckbox;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuTypeSelect;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberGPUsSelect;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDsSelect;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement locationSelect;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.soleTenant.location']")
    private WebElement locationSelectExpanded;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsageSelect;
    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateButton;

    public PricingCalculatorPage(){
        super();
        PageFactory.initElements(webDriver, this);
    }

    public PricingCalculatorPage fillPricingCalculatorForm(VirtualMachineData dataForPricing){

        WebElement outerFrame = webDriver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe"));
        webDriver.switchTo().frame(outerFrame);
        WebElement iframe = webDriver.findElement(By.id("myFrame"));
        webDriver.switchTo().frame(iframe);

        computeEngine.click();
        instancesAmountInput.sendKeys(dataForPricing.getMachinesAmount());
        selectOperatingSystem(dataForPricing.getOperatingSystem());
        selectProvisioningModel(dataForPricing.getProvisioningModel());
        selectMachineSeries(dataForPricing.getMachineSeries());
        selectMachineType(dataForPricing.getMachineType());
        addGPUCheckbox.click();
        selectGPUsType(dataForPricing.getGpuType());
        selectGPUsNumber(dataForPricing.getNumberOfGPUs());
        selectLocalSSDs(dataForPricing.getLocalSSDs());
        selectLocation(dataForPricing.getDataCenterLocation());
        selectCommittedUsage(dataForPricing.getCommittedUsageTerm());

        return this;
    }

    public CalculationResultsPage openCalculationResultsPage(){
        addToEstimateButton.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//md-content[@ng-if='cloudCartCtrl.showComputeItems']//md-list-item")));
        return new CalculationResultsPage();
    }

    public PricingCalculatorPage selectOperatingSystem(String xpathOptionTag){
        operatingSystemSelect.click();
        waitForExpandedDropdownOf(operatingSystemSelect);
        webDriver.findElement(By.xpath(String.format(COMMON_OPTION_XPATH, xpathOptionTag))).click();
        return this;
    }

    public PricingCalculatorPage selectProvisioningModel(String xpathOptionTag){
        provisioningModelSelect.click();
        waitForExpandedDropdownOf(provisioningModelSelect);
        webDriver.findElement(By.xpath(String.format(COMMON_OPTION_XPATH, xpathOptionTag))).click();
        return this;
    }

    public PricingCalculatorPage selectMachineSeries(String xpathOptionTag){
        machineSeriesSelect.click();
        waitForExpandedDropdownOf(machineSeriesSelect);
        webDriver.findElement(By.xpath(String.format(COMMON_OPTION_XPATH, xpathOptionTag))).click();
        return this;
    }

    public PricingCalculatorPage selectMachineType(String xpathOptionTag){
        machineTypeSelect.click();
        waitForExpandedDropdownOf(machineTypeSelect);
        webDriver.findElement(By.xpath(String.format(COMMON_OPTION_XPATH, xpathOptionTag))).click();
        return this;
    }
    public PricingCalculatorPage selectGPUsType(String xpathOptionTag){
        gpuTypeSelect.click();
        waitForExpandedDropdownOf(gpuTypeSelect);
        webDriver.findElement(By.xpath(String.format(COMMON_OPTION_XPATH, xpathOptionTag))).click();
        return this;
    }

    public PricingCalculatorPage selectGPUsNumber(String xpathOptionTag){
        numberGPUsSelect.click();
        waitForExpandedDropdownOf(numberGPUsSelect);
        webDriver.findElement(By.xpath(String.format(GPU_NUMBER_OPTION_XPATH, xpathOptionTag))).click();
        return this;
    }

    public PricingCalculatorPage selectLocalSSDs(String xpathOptionTag){
        localSSDsSelect.click();
        waitForExpandedDropdownOf(localSSDsSelect);
        webDriver.findElement(By.xpath(String.format(LOCAL_SSD_OPTION_XPATH, xpathOptionTag))).click();
        return this;
    }

    public PricingCalculatorPage selectLocation(String xpathOptionTag){
        locationSelect.click();
        waitForExpandedDropdownOf(locationSelect);
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .visibilityOf(locationSelectExpanded));
        webDriver.findElement(By.xpath(String.format(LOCATION_OPTION_XPATH, xpathOptionTag))).click();
        return this;
    }

    public PricingCalculatorPage selectCommittedUsage(String xpathOptionTag){
        committedUsageSelect.click();
        waitForExpandedDropdownOf(committedUsageSelect);
        webDriver.findElement(By.xpath(String.format(COMMITED_USAGE_OPTION_XPATH, xpathOptionTag))).click();
        return this;
    }

    private void waitForExpandedDropdownOf(WebElement webElement){
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(webElement, "aria-expanded", "true"));
    }

    @Override
    protected PricingCalculatorPage openPage() {
        webDriver.navigate().to(HOMEPAGE_URL);
        return this;
    }
}
