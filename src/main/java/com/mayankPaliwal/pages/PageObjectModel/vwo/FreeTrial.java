package com.mayankPaliwal.pages.PageObjectModel.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreeTrial {

    WebDriver driver = new ChromeDriver();

    // param const
    public FreeTrial(WebDriver driver){
        this.driver = driver;
    }

    private By freeTrialLink = By.linkText("Start a free trial");

    private By email_inp = By.id("page-v1-step1-email");
    private By freeTrial_checkbox = By.name("gdpr_consent_checkbox");
    private By create_trial_accnt_btn = By.tagName("button");
    private By err_msg = By.className("invalid-reason");

    public String enterDetails(String email){
               driver.get("https://app.vwo.com");
//               driver.get("https://vwo.com/free-trial/");
               driver.findElement(freeTrialLink).click();
               driver.findElement(email_inp).sendKeys(email);
               driver.findElement(freeTrial_checkbox).click();
               driver.findElement(create_trial_accnt_btn).click();

               String error = driver.findElement(err_msg).getText();

               return error;
    }

}
