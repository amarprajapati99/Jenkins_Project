package com.bridgelabz.selenium.jenkins;

import com.bridgelabz.selenium.jenkins.base.BaseClass;
import com.bridgelabz.selenium.jenkins.pages.Login;
import com.bridgelabz.selenium.jenkins.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FacebookTesting extends BaseClass{

    public Connection connection;
    public static int rowCount;


    @Test (priority = 1)
    public void getTableData() throws SQLException {

        connection = this.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from login");
        Log.info("************************ Table Data *******************");
        System.out.println("id " + " username " + " password " + " salary ");
        System.out.println("---------------------------------------------------------");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String username = resultSet.getString(2);
            String password = resultSet.getString(3);
            String salary = resultSet.getString(4);
            System.out.println(id + " " + username + " " + password + " " + salary);
            rowCount++;
            System.out.println("---------------------------------------------------------");
        }
    }


    @Test(priority = 2)
    public void login_to_application_using_DB_data() throws InterruptedException, SQLException{

        setUpBrowserLaunching();
        ResultSet resultSet;
        String gmailId;
        String userPass;
        connection = this.getConnection();
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from login LIMIT 1");
        while (resultSet.next()) {
            Login login = new Login(driver);

            gmailId = resultSet.getString(2);
            userPass = resultSet.getString(3);

            login.setEmailId(gmailId);
            login.setPassword(userPass);
            login.clickLogin();
            String expectedEmail = "amarprajapati99@gmail.com";
            Assert.assertEquals(gmailId, expectedEmail);
            driver.close();
        }
    }
}
