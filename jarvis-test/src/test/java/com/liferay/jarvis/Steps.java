package com.liferay.jarvis; 

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 

import cucumber.api.java8.En;
import cucumber.api.PendingException;

public class Steps implements En { 
   WebDriver driver = null; 

   public Steps() {
      Given("^I have opened the browser$", () -> {
         driver = new FirefoxDriver();
      });

      Given("^I navigate to \"([^\"]*)\"$", (String arg1) -> {
         driver.get(arg1);
      });

      Given("^I click on link having text \"([^\"]*)\"$", (String arg1) -> {
         driver.findElement(By.linkText(arg1)).click();
      });

      Then("^I wait for modal with id \"([^\"]*)\"$", (String arg1) -> {
         WebDriverWait wait = new WebDriverWait(driver, 5);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(arg1)));
      });

      Then("^I clear input field having id \"([^\"]*)\"$", (String arg1) -> {
         driver.findElement(By.id(arg1)).clear();
      });

      Then("^I enter \"([^\"]*)\" into input field having id \"([^\"]*)\"$", (String arg1, String arg2) -> {
         driver.findElement(By.id(arg2)).sendKeys(arg1);
      });

      Then("^I click on element having class \"([^\"]*)\" and text \"([^\"]*)\"$", (String arg1, String arg2) -> {
         WebElement element = driver.findElement(By.className(arg1));

         if (element.getText().equals(arg2)) {
            element.click();
         }
      });

      Then("^I close driver$", () -> {
         driver.quit();
      });
   }
}