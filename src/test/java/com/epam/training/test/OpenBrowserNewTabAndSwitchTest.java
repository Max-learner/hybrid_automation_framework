package com.epam.training.test;

import com.epam.training.page.EmailServicePage;
import com.epam.training.service.BrowserTabOperator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenBrowserNewTabAndSwitchTest extends  TestEnvironmentSetup{

    private final String emailSubject = "some subject";
    private final String emailText = "text to paste";

    @Test (description = "Service test in test system")
    public void openBrowserNewTabAndSwitchTest() throws InterruptedException {

        EmailServicePage emailServicePage = new EmailServicePage(webDriver).openInbox();
//        System.out.println(emailServicePage.getEmail());

        BrowserTabOperator browserTabOperator = new BrowserTabOperator(webDriver);
        browserTabOperator.openNewTab();
        browserTabOperator.switchToFirstTab();

        EmailServicePage emailServiceSupportingPage = new EmailServicePage(webDriver)
                .openInbox()
                .setRecepientEmailAddress(emailServicePage.getEmail())
                .writeAndSendNewMessage(emailSubject, emailText);

        browserTabOperator.switchToDefaultTab();
        emailServicePage.refreshInbox();
//        System.out.println(emailServicePage.getReceivedMessageText());

        Assert.assertEquals(emailServicePage.getReceivedMessageText(), emailText);
    }

}
