package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage extends AbstractPage{

    private final String SEARCH_RESULT_XPATH = "//b[contains(text(), 'Google') and contains(text(), 'Cloud') and contains(text(), 'Platform') and contains(text(), 'Pricing') and contains(text(), 'Calculator')]//parent::a";
    @FindBy(xpath = SEARCH_RESULT_XPATH)
    private WebElement pricingCalculatorPageLink;

    public SearchResultsPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return this;
    }

    public PricingCalculatorPage navigateToPricingCalculatorPage(){
        pricingCalculatorPageLink.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//iframe")));
        return new PricingCalculatorPage(webDriver);
    }
}
