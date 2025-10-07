package com.mayankPaliwal.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitHelpers  {

    // 3rd september

    public static void javaWait(String duration){
         try {
             Thread.sleep(Integer.parseInt(duration));
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }

     public  void waitImplicit(WebDriver driver,int duration){
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
     }

     public void checkVisiblity(WebDriver driver,By locators , int duration){
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
         wait.until(ExpectedConditions.visibilityOfElementLocated(locators));
     }

    public static void checkVisibility(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void checkVisibilityOfAndTextToBePresentInElement(WebDriver driver,WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
//        wait.until(ExpectedConditions.textToBePresentInElement(element, "Your email, password, IP address or location did not match"));

    }

    public static void waitForVisibility(WebDriver driver,int duration, String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }

    public static void  waitFluentVisibility(WebDriver driver, int maxTime, int pollingTime, String xpath) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(maxTime))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement error_message = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(xpath));
            }
        });
    }

    }
