package com.mayankPaliwal.pages.PageObjectModel.vwo;

import com.mayankPaliwal.utils.PropertiesReader;
import com.mayankPaliwal.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // page class
    WebDriver driver;

//    Step-0 - Param Constructor -> we have to set this for driver
    public LoginPage(WebDriver driver){
    this.driver = driver;
    }


    // Step -1 ==> Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // If you are not using it , don't keep.
    //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");




    // Step - 2 ==> Page Actions  [action what this page do ]
    // valid and invalid login

    public String  logintoVWOLoginInvalidCreds(String user, String pwd){

        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        WaitHelpers.checkVisibility(driver,error_message);

        String error_msg_text = driver.findElement(error_message).getText();
        return error_msg_text;
    }


    public void  logintoVWOLoginValidCreds(String user , String pwd){

//        driver.get("https://app.vwo.com");     // no hard code directly we read form Daata.properties file
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        WaitHelpers.javaWait("3000");
    }




}
