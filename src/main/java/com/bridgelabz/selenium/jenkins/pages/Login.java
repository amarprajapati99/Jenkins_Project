package com.bridgelabz.selenium.jenkins.pages;

import com.bridgelabz.selenium.jenkins.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass{

    @FindBy (id = "email")
    WebElement emailId;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement userPass;

    @FindBy(name = "login")
    WebElement submitButton;

    //parameterized constructor is used
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this); //initElements method is used to initialize web elements
    }

    public void setEmailId(String username) throws InterruptedException {
        Thread.sleep(1000);
        emailId.sendKeys(username);
    }

    public void setPassword(String password) throws InterruptedException {
        Thread.sleep(1000);
        userPass.sendKeys(password);
    }

    public void clickLogin() throws InterruptedException {
        Thread.sleep(1000);
        submitButton.click();
    }
}

