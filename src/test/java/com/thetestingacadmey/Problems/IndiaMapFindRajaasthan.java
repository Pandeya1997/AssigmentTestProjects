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

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.List;

public class IndiaMapFindRajaasthan {
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
    @Description("open the map application of svg india map find the rajaasthan and click on it")
    public void Find_SVG_Search_Element_Flipkart(){
        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL);
        List<WebElement> States = driver.findElements(By.xpath("//*[name() = \"svg\"]/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for (WebElement state :States){
            System.out.println(state.getAttribute("aria-label"));
            if (state.getAttribute("aria-label").contains("Rajasthan")){
                state.click();
                System.out.println(state.getAttribute("aria-label").contains("Rajasthan"));
            }
        }
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
