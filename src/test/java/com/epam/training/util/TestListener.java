package com.epam.training.util;

import com.epam.training.browserdriver.BrowserDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener, IConfigurationListener {

    private Logger logger = LogManager.getRootLogger();

    @Override
    public void onConfigurationFailure(ITestResult tr, ITestNGMethod tm) {
        saveScreenshot();;
    }

    public void onTestFailure(ITestResult iTestResult) {
    saveScreenshot();
}

    private void saveScreenshot(){
        File screenShot = ((TakesScreenshot) BrowserDriver
                .getWebDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(".//target/screenshots/"
                    + getCurrentTimeAsString() +
                    ".png"));
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
