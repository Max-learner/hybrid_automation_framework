package com.epam.training.util;

import com.epam.training.browserdriver.BrowserDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private Logger logger = LogManager.getRootLogger();

    public void onTestStart(ITestResult iTestResult){}
    public void onTestSuccess(ITestResult iTestResult){}
    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
    }
    @Override
    public void onTestSkipped(ITestResult result) {
    }
    @Override
    public void onStart(ITestContext context) {
    }
    @Override
    public void onFinish(ITestContext context) {
    }

    private void saveScreenshot(){
        File screenShot = ((TakesScreenshot) BrowserDriver
                .getWebDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(".//target/screenshots/"
                    + getCurrentTimeAsAtring() +
                    ".png"));
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }
    private String  getCurrentTimeAsAtring(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
