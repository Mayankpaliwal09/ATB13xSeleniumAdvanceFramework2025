package com.mayankPaliwal.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonToAll {

//        public WebDriver driver;
        public void openBrowser(WebDriver driver , String url ){

//            if(browser.equalsIgnoreCase("chrome")){
//                driver = new ChromeDriver();
//            } else if (browser.equalsIgnoreCase("firefox")){
//                driver = new FirefoxDriver();
//            } else {
//                driver = new ChromeDriver();
//            }
            driver.manage().window().maximize();
            driver.get(url);

        }


//        public void  javaWait(int waitTime){
//            try {
//                Thread.sleep(waitTime);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }

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
