package com.epam.training.page;

import com.epam.training.model.EmailAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailYourEstimatePage extends AbstractPage{

    @FindBy(xpath = "//input[contains(@ng-model, 'emailQuote.user.email')]")
    private WebElement inputEmail;
    @FindBy(xpath = "//button[contains(@ng-click, 'emailQuote.emailQuote')]")
    private WebElement sendEmailButton;

    public EmailYourEstimatePage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return this;
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
}
