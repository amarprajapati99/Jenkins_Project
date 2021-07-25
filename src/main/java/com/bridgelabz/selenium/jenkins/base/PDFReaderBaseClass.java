package com.bridgelabz.selenium.jenkins.base;

import com.bridgelabz.selenium.jenkins.utility.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PDFReaderBaseClass{

    public static WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Log.info("Chrome browser is setting");
        driver = new ChromeDriver();
        Log.info("Chrome driver is launched");
        driver.get("E:\\Notes\\1. R.S Aggarwal Quantitative Aptitude ( PDFDrive.com ).pdf");
    }

    @AfterTest
    public void tearDown(){
        Log.info("Browser is closed");
        driver.quit();
        Log.info("Test is ended");
        Reporter.log("Application Launched");
    }
}

