package com.epam.training.browserdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserDriver {
    private static WebDriver webDriver;

    private BrowserDriver(){}

    public static WebDriver getWebDriver(){
        if (webDriver == null){
            switch (System.getProperty("browser")){
                case "edge":{
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                }
            }
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }

    public static void closeWebdriver(){
//        webDriver.quit();
        webDriver = null;
    }

}
