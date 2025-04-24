package com.thetestingacadmey.Problems;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class SVGsearch_Flipkart {
    EdgeOptions options;
    WebDriver driver;
    @BeforeSuite
    public  void OpenBrowser(){
    options = new EdgeOptions();
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    driver = new EdgeDriver(options);
    driver.manage().window().maximize();
    }
    @Test (testName = "Positive Test Case")
    @Description("Search for the Macmini in the FLipkart.com and click the search icon svg ")
    public void Find_SVG_Search_Element_Flipkart(){
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
       // WebElement searchBox = driver.findElement(By.xpath("//input[@type = 'text']"));
        // or
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("macmini");
        driver.findElement(By.name("q")).sendKeys("macmini");
     List<WebElement> buttonclick = driver.findElements(By.xpath("//*[name() = \"svg\"]"));
       buttonclick.get(0).click();
    }
    @AfterSuite
    public void ClosedBroser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
      driver.quit();
    }
}
