package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculationResultsPage extends AbstractPage{
    private String actualTotalCost;
    private final String xpathStart = "//md-content[@ng-if='cloudCartCtrl.showComputeItems']//div[contains(text(),'";
    private final String xpathEnd = "')]";
    @FindBy(xpath = xpathStart + "Region" + xpathEnd)
    private WebElement dataCenterLocation;
    @FindBy(xpath = xpathStart + "Commitment" + xpathEnd)
    private WebElement commitedUsageTerm;
    @FindBy(xpath = xpathStart + "Provisioning" + xpathEnd)
    private WebElement provisioningModel;
    @FindBy(xpath = xpathStart + "Instance" + xpathEnd)
    private WebElement machineType;
    @FindBy(xpath = xpathStart + "SSD" + xpathEnd)
    private WebElement localSSD;
    @FindBy(xpath = "//div[@class='cpc-cart-total']//b[contains(text(), 'Total Estimated Cost')]")
    private WebElement totalCost;
    @FindBy(xpath = "//button[@id='Email Estimate']")
    private WebElement emailEstimateButton;

    public CalculationResultsPage(){
        super();
        PageFactory.initElements(webDriver, this);
    }

    public EmailYourEstimatePage openEmailYourEstimatePage() throws InterruptedException {
        emailEstimateButton.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//input[contains(@ng-model, 'email')]")));
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@ng-click, 'emailQuote.emailQuote')]")));
        return new EmailYourEstimatePage();
    }

    // remove to services
//    public VirtualMachineData getVirtualMachineDataFromResults() {
//
//        VirtualMachineData calculatedVirtualMachineData = new VirtualMachineData();
//
//        calculatedVirtualMachineData.setDataCenterLocation(getDataCenterLocation());
//        calculatedVirtualMachineData.setCommittedUsageTerm(getCommitedUsageTerm());
//        calculatedVirtualMachineData.setProvisioningModel(getProvisioningModel());
//        calculatedVirtualMachineData.setMachineType(getMachineType());
//        calculatedVirtualMachineData.setLocalSSDs(getLocalSSD());
//
//        return calculatedVirtualMachineData;
//    }

    public String getDataCenterLocation(){
        return dataCenterLocation.getText();
    }

    public String getCommitedUsageTerm(){
        return commitedUsageTerm.getText();
    }

    public String getProvisioningModel(){
        return provisioningModel.getText();
    }

    public String getMachineType(){
        return machineType.getText();
    }

    public String getLocalSSD(){
        return localSSD.getText();
    }

    public String getTotalCost(){
        return totalCost.getText();
    }

    public String getActualTotalCost() {
        return actualTotalCost;
    }

    public void setActualTotalCost(String actualTotalCost) {
        this.actualTotalCost = actualTotalCost;
    }

    @Override
    protected CalculationResultsPage openPage() {
        return this;
    }
}
