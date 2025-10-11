package com.mayankPaliwal.base;

import com.mayankPaliwal.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class CommonToAll {


    //we have to set browser
    @BeforeMethod
    public void setUp(){
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }



    public static void closeBrowser(WebDriver driver){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }


    public WebElement partialText( WebDriver driver , String partiallinkText) {

       WebElement partialLink = driver.findElement(By.partialLinkText(partiallinkText));
        partialLink.click();

        return partialLink;

    }


    public WebElement FindElementbyXpath(WebDriver driver, String xpath){

            WebElement element = driver.findElement(By.xpath(xpath));

        return element;
    }

    public WebElement FindElementbyId(WebDriver driver, String id){

        WebElement element = driver.findElement(By.id(id));
//        System.out.println(element.getText());
        return element;
    }


    public List<WebElement> FindElementsbyId(WebDriver driver, String xpath){
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        return elements;
    }



}
