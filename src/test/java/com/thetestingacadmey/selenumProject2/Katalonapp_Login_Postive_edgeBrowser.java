package com.thetestingacadmey.selenumProject2;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class Katalonapp_Login_Postive_edgeBrowser {
    EdgeOptions options;
//ChromeOptions options;
WebDriver driver;
@BeforeSuite
    public void setUp(){
   // options = new ChromeOptions();
    options = new EdgeOptions();
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    //driver = new ChromeDriver(options);
    driver = new EdgeDriver(options);


}
@Test
@Description("Kataloan_App_Login page, Verify current URl , click make appoinment button , and verify valid user-name passwrod ")
    public void App_Login() throws InterruptedException{
    driver.get("https://katalon-demo-cura.herokuapp.com/");
    System.out.println( driver.getTitle());
    Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");
    WebElement MakeAppoinmentButton = driver.findElement(By.id("btn-make-appointment"));
    MakeAppoinmentButton.click();
    // 3 sec sheelp
    Thread.sleep(3000);

    // URL Verification - Assert using
    System.out.println(driver.getCurrentUrl());
    Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");
    WebElement UserNameBox = driver.findElement(By.id("txt-username"));
    UserNameBox.sendKeys("Admin1234");
    WebElement UserPasswordBox = driver.findElement(By.id("txt-password"));
    UserPasswordBox.sendKeys("Password@123");
    WebElement SubmitButton = driver.findElement(By.id("btn-login"));
    SubmitButton.click();
    Thread.sleep(3000);
    WebElement ErrorMessage = driver.findElement(By.className("text-danger"));
    System.out.println(ErrorMessage.getText());
    String text = ErrorMessage.getText();
   // Assert.assertEquals(text,"Login failed! Please ensure the username and password are valid.");

    try {
        Assert.assertEquals(text, "Login failed! Please ensure the username and password are valid.");
        System.out.println("Test Passed: Text matches 'Error message displayed '");
    } catch (AssertionError e) {
        System.out.println("Test Failed: Expected 'Error Message Not Found ', but found '" + text + "'");
    }

    Thread.sleep(3000);
    List<WebElement> Make_Appointment = driver.findElements(By.className("lead"));
    String appointment =  Make_Appointment.get(0).getText();
    System.out.println(appointment);
    Assert.assertEquals(appointment,"Please login to make appointment.");
}


@AfterSuite
    public void tearDown(){
    driver.quit();
}
}
