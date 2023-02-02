package com.epam.training.test;

import com.epam.training.page.*;
import com.epam.training.service.VirtualMachineDataCreator;
import com.epam.training.service.EmailAddressCreator;
import com.epam.training.service.SearchQueryCreator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleCloudPlatformCalculatorTest extends TestEnvironmentSetup {

    protected SoftAssert softAssert;

    @BeforeClass(alwaysRun = true,
            description = "Open Calculator page, fill data, get calculation results")
    public void openCalculatorPageFillDataAndGetCalculationResults(){

        softAssert = new SoftAssert();
        newSearchQuery = SearchQueryCreator.withRequiredData();

        pricingCalculatorPage =  new GoogleCloudPlatformHomePage()
                .openHomePage()
                .activateSearch(newSearchQuery)
                .openPricingCalculatorPage();

        virtualMachineDataForPricing = VirtualMachineDataCreator.withAllRequiredData();

        calculationResultsPage = pricingCalculatorPage
                .fillPricingCalculatorForm(virtualMachineDataForPricing)
                .openCalculationResultsPage();
    }

    @Test (description = "Check calculation data is set properly")
    public void pricingCalculatorResultsCalculationTest() {
        //rewrite method getVirtualMachineDataFromResults
//        softAssert.assertEquals(
//                calculationResultsPage.getVirtualMachineDataFromResults(),
//                virtualMachineDataForPricing,
//                "Virtual Machine data in calculation is not equal to input"
//                );
        softAssert.assertEquals(
                VirtualMachineDataCreator.getVirtualMachineDataFromResults(),
                virtualMachineDataForPricing,
                "Virtual Machine data in calculation is not equal to input"
        );

        calculationResultsPage.setActualTotalCost(calculationResultsPage.getTotalCost());

        softAssert.assertTrue(calculationResultsPage.getActualTotalCost().contains("1,081.20"),
                "Total cost doesn't equal to manual test total cost");
    }

    @Test(dependsOnMethods = {"pricingCalculatorResultsCalculationTest"},
            description = "Open email service, get email address, send calculation results")
    public void getEmailAddressAndSendEmail() throws InterruptedException {

        emailYourEstimatePage = calculationResultsPage
                .openEmailYourEstimatePage()
                .openNewTab()
                .switchToNewTab();

        emailServicePage = new EmailServicePage().openInbox();

        String pageTitle = webDriver.getTitle();

        emailAddress = EmailAddressCreator.withRequiredData(emailServicePage);

        emailYourEstimatePage
                .switchToDefaultTab()
                .fillFormAndSubmit(emailAddress)
                .switchToNewTab();

        softAssert.assertEquals(webDriver.getTitle(), pageTitle, "Email pages are not equal");
    }

    @Test (dependsOnMethods = {"getEmailAddressAndSendEmail"},
            description = "Check received cost")
    public void pricingCalculatorResultsEmailingTest() throws InterruptedException {

        String receivedEstimatedTotalCost = emailServicePage
                .refreshInbox()
                .getReceivedEstimatedTotalCost();

        softAssert.assertTrue(calculationResultsPage
                        .getActualTotalCost()
                        .contains(receivedEstimatedTotalCost),
                "Received cost doesn't equal to send cost");
    }

    @AfterClass(alwaysRun = true, description = "assert all tests")
    public void finishAsserts(){
        softAssert.assertAll();
    }
}
