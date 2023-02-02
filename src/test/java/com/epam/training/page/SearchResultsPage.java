package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage{

    private final String SEARCH_RESULT_XPATH = "//b[contains(text(), 'Google Cloud Platform Pricing Calculator')]//parent::a";
    @FindBy(xpath = SEARCH_RESULT_XPATH)
    private WebElement pricingCalculatorPageLink;

    public SearchResultsPage(){
        super();
        PageFactory.initElements(webDriver, this);
    }

    public PricingCalculatorPage openPricingCalculatorPage(){
        pricingCalculatorPageLink.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//iframe")));
        return new PricingCalculatorPage();
    }

    @Override
    protected SearchResultsPage openPage() {
        return this;
    }
}
