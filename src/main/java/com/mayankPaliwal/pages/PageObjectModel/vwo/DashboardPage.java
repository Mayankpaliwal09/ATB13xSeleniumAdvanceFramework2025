package com.mayankPaliwal.pages.PageObjectModel.vwo;

import com.mayankPaliwal.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }


    private By userNameOnDashBoard = By.xpath("//h6");

    public String loggedInUserName(){
        WaitHelpers.javaWait("5000");
        driver.get("https://app.vwo.com/#/dashboard");
        return driver.findElement(userNameOnDashBoard).getText();
    }
}
