package com.epam.training.page;

import com.epam.training.model.EmailAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailYourEstimatePage extends AbstractPage{

    @FindBy(xpath = "//input[contains(@ng-model, 'emailQuote.user.email')]")
    private WebElement inputEmail;
    @FindBy(xpath = "//button[contains(@ng-click, 'emailQuote.emailQuote')]")
    private WebElement sendEmailButton;

    public EmailYourEstimatePage(){
        super();
        PageFactory.initElements(webDriver, this);
    }

    public EmailYourEstimatePage fillFormAndSubmit(EmailAddress emailAddress){
        WebElement outerFrame = webDriver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe"));
        webDriver.switchTo().frame(outerFrame);
        WebElement innerframe = webDriver.findElement(By.id("myFrame"));
        webDriver.switchTo().frame(innerframe);

        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//input[contains(@ng-model, 'email')]")));

        inputEmail.sendKeys(emailAddress.getRecepientEmailAddress());
        sendEmailButton.click();
        return this;
    }

    @Override
    public EmailYourEstimatePage openNewTab() {
        super.openNewTab();
        return this;
    }

    @Override
    public EmailYourEstimatePage switchToNewTab() {
        super.switchToNewTab();
        return this;
    }

    @Override
    public EmailYourEstimatePage switchToDefaultTab() {
        super.switchToDefaultTab();
        return this;
    }

    @Override
    protected EmailYourEstimatePage openPage() {
        return this;
    }
}
