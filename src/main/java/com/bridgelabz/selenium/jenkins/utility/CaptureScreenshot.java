package com.bridgelabz.selenium.jenkins.utility;

import com.bridgelabz.selenium.jenkins.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenshot extends BaseClass{

    public void captureScreenshot (String screenshotName, String result) throws IOException {
        String date = new SimpleDateFormat ("yyyy_MM_dd_hhmmss").format (new Date ());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs (OutputType.FILE);

        File destFile = new File ("F:\\Selenium\\JenkinsProject\\screenshot" + result + "\\" + screenshotName + "_" + date + ".png");
        FileUtils.copyFile (srcFile, destFile);
    }
}

