package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculationResultsPage extends AbstractPage{
//    private WebDriver webDriver;
//    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    @FindBy(xpath = "//md-content[@ng-if='cloudCartCtrl.showComputeItems']//div[contains(text(),'Region:')]")
    private WebElement dataCenterLocation;
    @FindBy(xpath = "//md-content[@ng-if='cloudCartCtrl.showComputeItems']//div[contains(text(),'Commitment')]")
    private WebElement commitmentTerm;
    @FindBy(xpath = "//md-content[@ng-if='cloudCartCtrl.showComputeItems']//div[contains(text(),'Provisioning')]")
    private WebElement provisioningModel;
    @FindBy(xpath = "//md-content[@ng-if='cloudCartCtrl.showComputeItems']//div[contains(text(),'Instance')]")
    private WebElement machineType;
    @FindBy(xpath = "//md-content[@ng-if='cloudCartCtrl.showComputeItems']//div[contains(text(),'SSD')]")
    private WebElement localSSD;
    @FindBy(xpath = "//div[@class='cpc-cart-total']//b[contains(text(), 'Total Estimated Cost')]")
    private WebElement totalCost;
    @FindBy(xpath = "//button[@id='Email Estimate']")
    private WebElement emailEstimateButton;

    public CalculationResultsPage(WebDriver webDriver){
        super(webDriver);
//        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return this;
    }

    public EmailYourEstimatePage openEmailYourEstimatePage() throws InterruptedException {
        emailEstimateButton.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//input[contains(@ng-model, 'email')]")));
        Thread.sleep(5000);
        return new EmailYourEstimatePage(webDriver);
    }
    public String readDataCenterLocation(){
        return dataCenterLocation.getText();
    }
    public String readCommitmentTerm(){
        return commitmentTerm.getText();
    }
    public String readProvisioningModel(){
        return provisioningModel.getText();
    }
    public String readMachineType(){
        return machineType.getText();
    }
    public String readLocalSSD(){
        return localSSD.getText();
    }
    public String readTotalCost(){
        return totalCost.getText();
    }
}
