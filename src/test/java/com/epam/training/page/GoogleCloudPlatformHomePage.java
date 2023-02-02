package com.epam.training.page;

import com.epam.training.model.SearchQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPlatformHomePage extends AbstractPage{

    private final String HOMEPAGE_URL = " https://cloud.google.com/";
    private Logger logger = LogManager.getRootLogger();
    @FindBy(name = "q")
    private WebElement searchInput;

    public GoogleCloudPlatformHomePage(){
        super();
        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudPlatformHomePage openHomePage(){
        webDriver.get(HOMEPAGE_URL);
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.className("devsite-searchbox")));
        return this;
    }

    public SearchResultsPage activateSearch(SearchQuery searchQuery){
        searchInput.click();
        searchInput.sendKeys(searchQuery.getSearchQuery());
        searchInput.submit();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//a[@class='gs-title']")));
        logger.info("Activated search with words: " + searchQuery.getSearchQuery());
        return new SearchResultsPage();
    }

    @Override
    protected GoogleCloudPlatformHomePage openPage() {
        webDriver.navigate().to(HOMEPAGE_URL);
        return this;
    }
}
