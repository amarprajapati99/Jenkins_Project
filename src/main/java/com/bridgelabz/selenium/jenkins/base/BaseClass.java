package com.bridgelabz.selenium.jenkins.base;

import com.bridgelabz.selenium.jenkins.utility.CustomException;
import com.bridgelabz.selenium.jenkins.utility.IConstant;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass implements IConstant{

    public static WebDriver driver;
    static Connection connection;

    @Severity (SeverityLevel.CRITICAL)
    @Story ("Connection to the database")
    @BeforeTest
    public Connection getConnection() {
        try {
            //created a database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            //get connection to database
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            if (connection != null) {
                System.out.println("Server is connected");
            } else {
                throw new CustomException (CustomException.ExceptionType.DB_CONNECTION_NOT_CONNECTED, "TO check data base server connection");
            }
        } catch (ClassNotFoundException | SQLException | CustomException exception) {
            System.out.println(exception.getMessage());
        }
        return connection;
    }

    @Severity (SeverityLevel.CRITICAL)
    @Story ("Lunching the browser")
    public void setUpBrowserLaunching() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver (options);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() throws SQLException {
        connection.close();
    }
}

