package com.thetestingacadmey.selenumProject1;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

public class VWO_Login_Postive {
    @Test
    public  void VWOLogin() throws InterruptedException{
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        WebElement EmailIDInputBox = driver.findElement(By.id("login-username"));
        EmailIDInputBox.sendKeys("contact+atb7x@thetestingacademy.com");
        WebElement PasswordInputBox = driver.findElement(By.name("password"));
        PasswordInputBox.sendKeys("Wingify@1234");
        WebElement Singbutton = driver.findElement(By.id("js-login-btn"));
        Singbutton.click();
        Thread.sleep(5000);
        WebElement DashBoard = driver.findElement(By.className("page-heading"));
        System.out.println(DashBoard.getText());
        Assert.assertEquals(DashBoard.getText(),"Dashboard");
        Thread.sleep(5000);


        WebElement element = driver.findElement(By.xpath("//span [@class = 'Fw(semi-bold) ng-binding']"));
        String text = element.getText();
        try {
            Assert.assertEquals(text, "Aman Ji");
            System.out.println("Test Passed: Text matches 'Aman Ji'");
        } catch (AssertionError e) {
            System.out.println("Test Failed: Expected 'Aman Ji', but found '" + text + "'");
        }


    {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        driver.quit();
    }
}
}