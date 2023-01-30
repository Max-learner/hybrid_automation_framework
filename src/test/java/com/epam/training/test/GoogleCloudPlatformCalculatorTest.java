package com.epam.training.test;

import com.epam.training.model.DataForPricing;
import com.epam.training.model.EmailAddress;
import com.epam.training.model.SearchQuery;
import com.epam.training.page.*;
import com.epam.training.service.BrowserTabOperator;
import com.epam.training.service.DataForPricingCreator;
import com.epam.training.service.EmailAddressCreator;
import com.epam.training.service.SearchQueryCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPlatformCalculatorTest extends TestEnvironmentSetup {

    @Test (description = "First test in test system")
    public void pricingCalculatorResultsEmailingTest() throws InterruptedException {

        SearchQuery newQuery = SearchQueryCreator.withRequiredData();

        PricingCalculatorPage pricingCalculatorPage =  new GoogleCloudPlatformHomePage(webDriver)
                .openHomePage()
                .activateSearch(newQuery)
                .navigateToPricingCalculatorPage();

        DataForPricing dataForPricing = DataForPricingCreator.withRequiredData();

        CalculationResultsPage calculationResultsPage = pricingCalculatorPage
                .fillPricingCalculatorForm(dataForPricing)
                .openCalculationResultsPage();

        String expectedDataCenterLocation = calculationResultsPage.readDataCenterLocation();
        Assert.assertTrue(expectedDataCenterLocation.contains("Frankfurt"));

        String expectedCommitmentTerm = calculationResultsPage.readCommitmentTerm();
        Assert.assertTrue(expectedCommitmentTerm.contains("1 Year"));

        String expectedProvisioningModel = calculationResultsPage.readProvisioningModel();
        Assert.assertTrue(expectedProvisioningModel.contains("Regular"));

        String expectedMachineType = calculationResultsPage.readMachineType();
        Assert.assertTrue(expectedMachineType.contains("n1-standard-8"));

        String expectedLocalSSD = calculationResultsPage.readLocalSSD();
        Assert.assertTrue(expectedLocalSSD.contains("2x375 G"));

        String expectedTotalCost = calculationResultsPage.readTotalCost();
        Assert.assertTrue(expectedTotalCost.contains("1,081.20"));

        EmailYourEstimatePage emailYourEstimatePage = calculationResultsPage.openEmailYourEstimatePage();

        BrowserTabOperator browserTabOperator = new BrowserTabOperator(webDriver);
        browserTabOperator.openNewTab();
        browserTabOperator.switchToFirstTab();

        EmailServicePage emailServicePage = new EmailServicePage(webDriver).openInbox();

        EmailAddress emailAddress = EmailAddressCreator.withRequiredData(emailServicePage);

        browserTabOperator.switchToDefaultTab();
        emailYourEstimatePage.fillFormAndSubmit(emailAddress);

        browserTabOperator.switchToFirstTab();
        String receivedEstimatedTotalCost = emailServicePage
                .refreshInbox()
                .getReceivedEstimatedTotalCost();
        Assert.assertTrue(expectedTotalCost.contains(receivedEstimatedTotalCost));
    }
}
