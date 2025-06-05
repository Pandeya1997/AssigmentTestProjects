package com.thetestingacadmey.IRCTC;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Normal_Wallet {
    EdgeOptions options;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void OpenBrowser(){
      options = new EdgeOptions();
      options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
      driver = new EdgeDriver(options);
      driver.manage().window().maximize();
      wait = new WebDriverWait(driver, Duration.ofSeconds(50));

      // Implicity wait, Explicity Wait, & Fulent wait working on browser
      //   Thread.sleep() , JVM wait

    }
    @Test(groups = "QA")
    @Description("Ticket Booking viw IRCTC Wailt")
    public void IRTC_Ticket_Booking() throws InterruptedException{
    String ULR = "https://www.irctc.co.in/nget/train-search";
    driver.get(ULR);
    // Login Button Click
    WebElement LoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"text-center h_main_div\"]/div/a[1]")));
    LoginButton.click();
    // Input User -Id
     WebElement InputUserId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname=\"userid\"]")));
     InputUserId.sendKeys("Vish198");
     // Input BOX Passowrd Filed
     WebElement PassINPUTFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname=\"password\"]")));
     PassINPUTFiled.sendKeys("Abhishek55");

     // Capthercode
        Thread.sleep(10000);

       WebElement buttonSING = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='SIGN IN']")));
       buttonSING.click();
//  //button[normalize-space()='SIGN IN']
       Thread.sleep(5000 );
    }

    @AfterSuite
    public void ClosedBroswer(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Closed Broswer ");
        driver.quit();
    }


}


