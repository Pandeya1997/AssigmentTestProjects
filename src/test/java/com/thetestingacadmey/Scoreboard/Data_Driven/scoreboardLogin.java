package com.thetestingacadmey.Scoreboard.Data_Driven;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class scoreboardLogin {
 EdgeOptions options;
 WebDriver driver;
 WebDriverWait wait;
@BeforeSuite
 public void OpenBrowser(){
  options = new EdgeOptions();
  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
  driver = new EdgeDriver(options);
  wait = new WebDriverWait(driver, Duration.ofSeconds(50));
 }

 @Test(dataProvider = "textDataExcel")
 @Description("Verify login with valid credentials")
  public void testDataDriven( String email, String password, String expectedResult){
 String URL = "https://scoreboard-ui.jaigovinda7.com/login";
 driver.get(URL);
  WebElement emailElement = driver.findElement(By.id("cust_user_id"));
  emailElement.clear();
  emailElement.sendKeys(email);
  WebElement passwordElement = driver.findElement(By.id("passwd"));
  passwordElement.clear();
  passwordElement.sendKeys(password);
  driver.findElement(By.xpath("//button[@type=\"button\" ]")).click();
  if (expectedResult.equalsIgnoreCase("Valid")){
// //span[@class='h6 user-role']
   String  text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='h6 user-role']"))).getText();
   System.out.println(text);
   Assert.assertEquals(text, "Admin - Director");

  }
if (expectedResult.equalsIgnoreCase("InValid")){
 String  error_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Login to Dashboard']"))).getText();
 System.out.println(error_message);
// Assert.assertTrue(error_message.isEmpty());
// Assert.assertEquals(error_message.getText(),"Login to Dashboard");


}

 }

 @DataProvider
 public String[][] textDataExcel() throws IOException {
  String testDataFile = "src/test/java/testData.xlsx";
  ExcelReader excelReader = new ExcelReader(testDataFile);
  String[][] data = excelReader.getDataFromSheet(testDataFile, "LoginData");
  return data;

 }
 @AfterSuite
 public void ClosedBrowser(){
     try {
         Thread.sleep(5000);
     } catch (InterruptedException e) {
         throw new RuntimeException(e);
     }
     driver.quit();
 }

}
