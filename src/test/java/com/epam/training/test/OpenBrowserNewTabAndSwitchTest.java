package com.epam.training.test;

import com.epam.training.page.EmailServicePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenBrowserNewTabAndSwitchTest extends  TestEnvironmentSetup{

    private final String emailSubject = "some subject";
    private final String emailText = "text to paste";

    @Test (description = "Open tabs with email service, send email and check received email text")
    public void openBrowserNewTabAndSwitchTest() throws InterruptedException {

        EmailServicePage emailServicePage = new EmailServicePage()
                .openInbox()
                .openNewTab()
                .switchToNewTab();

        EmailServicePage emailServiceSupportingPage = new EmailServicePage()
                .openInbox()
                .setRecepientEmailAddress(emailServicePage.getEmailAddress())
                .writeAndSendNewMessage(emailSubject, emailText);

        emailServiceSupportingPage.switchToDefaultTab();
        emailServicePage.refreshInbox();

        Assert.assertEquals(emailServicePage.getReceivedMessageText(), emailText,
                "Received message doesn't equal to Sent message");
    }

}
