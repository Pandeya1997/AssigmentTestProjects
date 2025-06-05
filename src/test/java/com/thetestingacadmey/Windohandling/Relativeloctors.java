package com.thetestingacadmey.Windohandling;

import com.beust.ah.A;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Relativeloctors {
    EdgeOptions options;
    WebDriver driver;
    WebDriverWait wait;
    @BeforeSuite
    public void OpenBrowser(){
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(500));


    }
    @Test(groups="QA")
    @Description("Relativeloctors Test Postive AQI FIND ")
    public void PostiveTest() throws InterruptedException{
        String URL = "https://www.aqi.in/in/real-time-most-polluted-city-ranking";
        driver.get(URL);

// Wait for the input box to be visible before interacting
         WebElement FindSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Search']")) );
        // Send text after the element is ready
            FindSearch.sendKeys("india"+Keys.ENTER);


//        Thread.sleep(5000);
//        WebElement FindSearch = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
//        FindSearch.sendKeys("india");

        // Xpath India search first elements name
        //p[@class= "font-bold text-[1.5em] sm:text-[1.7em] truncate"][1]
        Thread.sleep(5000);
 WebElement IndiaFistAQIPoorcity = driver.findElement(By.xpath("//p[@class= \"font-bold text-[1.5em] sm:text-[1.7em] truncate\"][1]"));
 WebElement aqi = driver.findElement(with(By.xpath("//span[@class=\"text-[1.5em] sm:text-[1.7em]\"][1]")).toRightOf(IndiaFistAQIPoorcity));
 WebElement rankAQI = driver.findElement(with(By.xpath("//p[@class=\"location-rank text-[1.4em] sm:text-[1.7em] text-center h-fit text-title dark:text-dark_title font-normal\" ][1]")).toLeftOf(IndiaFistAQIPoorcity));

 System.out.println("Rank =- "+rankAQI.getText()+"  City Name =-  "+ IndiaFistAQIPoorcity.getText()+"   AQI =- "+aqi.getText());

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        System.out.println("Scroll Down");
        Thread.sleep(3000);

    }

    @AfterSuite
    public void CLosedBrowser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
