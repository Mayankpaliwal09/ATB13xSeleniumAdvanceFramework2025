package com.mayankPaliwal.tests.vwo.pageObjectModelTC;

import com.mayankPaliwal.base.CommonToAll;
import com.mayankPaliwal.driver.DriverManager;
import com.mayankPaliwal.pages.PageObjectModel.vwo.DashboardPage;
import com.mayankPaliwal.pages.PageObjectModel.vwo.LoginPage;
import com.mayankPaliwal.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class testVWOLogin_02_Property_POM_with_driver_manager extends CommonToAll {

    // D - driver
    // L - locator
    // V - validations -> methods/asseertions

    @Owner("Mayank")
    @Description("Verifying the login with Invalid email,pass , error messge is showed")
    @Test
    public void  test_negative_VWO_Login(){


        // Driver manager code  - 1    ---> // before methid in [commonToAll] wiil call setup , teardown ---> and they will call init() and down() method of DriverManager

        // page class code (POM code) - 2    ---> L
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
//        String error_msg = loginPage.logintoVWOLoginInvalidCreds("admin@123.com","abc");
        String error_msg = loginPage.logintoVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));


        // Assertions - 3     ---> V
        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }


    @Owner("Mayank")
    @Description("Verifying the login with valid email,pass , dashboard page is loaded")
    @Test
    public void  testLoginPositiveVWO(){
        // Driver manager code  - 1    ---> D


        // page class code (POM code) - 2    ---> L
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
//        loginPage.logintoVWOLoginValidCreds("20010041034@gateway.edu.in","Paliwal@2609");
        loginPage.logintoVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String usernameFromDashboard = dashboardPage.loggedInUserName();


        // Assertions - 3     ---> V
        assertThat(usernameFromDashboard).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(usernameFromDashboard,PropertiesReader.readKey("expected_username"));


    }
}
