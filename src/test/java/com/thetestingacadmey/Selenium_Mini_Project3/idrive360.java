package com.thetestingacadmey.Selenium_Mini_Project3;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class idrive360 {
     EdgeOptions options;
     WebDriver driver;
     @BeforeSuite
    public void setUp(){
         options = new EdgeOptions();
      options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
      driver = new EdgeDriver(options);
     }
     @Test
     @Description("IDrive360 Login and User enter Email id And Password " +
             "& Verify the Your free trial has expired & verify current URL though the Assert ")
     public void IDrive360Login() throws InterruptedException{
         driver.get("https://www.idrive360.com/enterprise/login");
         Thread.sleep(3000);
         WebElement Email_id = driver.findElement(By.id("username"));
         Email_id.sendKeys("augtest_040823@idrive.com");
         WebElement Password = driver.findElement(By.id("password"));
         Password.sendKeys("123456");
         WebElement SignButton = driver.findElement(By.id("frm-btn"));
         SignButton.click();
         Thread.sleep(20000);
         WebElement ErrorMessage = driver.findElement(By.className("id-card-title"));
         String yourplanExpired = ErrorMessage.getText();
         try {
             Assert.assertEquals(yourplanExpired,"Your free trial has expired");
             System.out.println(yourplanExpired + " :- " +" Test Passed: Text matches 'Error message displayed '");
         } catch ( AssertionError e){
             System.out.println("Test Failed: Expected 'Error Message Not Found ', but found '");
         }
         System.out.println(driver.getCurrentUrl());
         String url = driver.getCurrentUrl();
          try {
              Assert.assertEquals(url,"https://www.idrive360.com/enterprise/account?upgradenow=true");
              System.out.println("Test Passed : Text matches ' Current URL displayed'");
          } catch (AssertionError e){
              System.out.println("Test Failed: Expected 'Current URL  Not Found ', but found '");
          }

     }

   @AfterSuite
   public void tearDown(){
         driver.quit();
   }
}
