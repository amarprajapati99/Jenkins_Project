package com.bridgelabz.selenium.jenkins.pages;

import com.bridgelabz.selenium.jenkins.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Dashboard extends BaseClass{

    @FindBy(xpath = "//input[@placeholder='Search Facebook']")
    WebElement searchFacebook;

    @FindBy(xpath = "//div[@aria-label='Account']")
    WebElement account;

    @FindBy(xpath = "//span[normalize-space()='Log Out']")
    WebElement logOut;

    public Dashboard (WebDriver driver) {
        PageFactory.initElements (driver,this);
    }

    public void setSearchFacebook(){

        searchFacebook.click ();
        searchFacebook.sendKeys ("blazeclan technologies");

        Actions actions = new Actions (driver);
        actions.sendKeys (Keys.ENTER).perform ();

        driver.manage ().timeouts ().implicitlyWait (5, TimeUnit.SECONDS);
        account.click ();
        logOut.click ();

    }
}
