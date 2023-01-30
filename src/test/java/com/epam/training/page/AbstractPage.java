package com.epam.training.page;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class AbstractPage {

    protected WebDriver webDriver;

    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    protected AbstractPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    protected abstract AbstractPage openPage();
}
