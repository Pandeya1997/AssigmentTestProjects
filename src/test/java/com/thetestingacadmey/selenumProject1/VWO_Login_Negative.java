package com.thetestingacadmey.selenumProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VWO_Login_Negative {
    @Test
public void VWO_Login_InvalidUserName () throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        //Find the Input Box and enter
        WebElement InputEmailAdd = driver.findElement(By.id("login-username"));
        InputEmailAdd.sendKeys("Amint@pandey.com");
        Thread.sleep(3000);
        WebElement InputPassword = driver.findElement(By.id("login-password"));
        InputPassword.sendKeys("pass@1234");
        WebElement ButtonSing = driver.findElement(By.id("js-login-btn"));
        ButtonSing.click();
        Thread.sleep(5000);
        WebElement ErrorMessage = driver.findElement(By.id("js-notification-box-msg"));
        System.out.println(ErrorMessage.getText());
        Assert.assertEquals(ErrorMessage.getText(),"Your email, password, IP address or location did not match");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
