package Homework5Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Поиск пунктов выдачи в Санкт Петербурге
public class Scenario2Test {

 @Test
  public void scenario2Test() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    Actions builder = new Actions(driver);
    driver.get("https://www.wildberries.ru/");

    builder
      .click(driver.findElement(By.id("head-pick-point-address")))
      .build()
      .perform();

    new WebDriverWait(driver, 80, 500)
     .until(ExpectedConditions.elementToBeClickable(By.className("ymaps-2-1-77-searchbox-input__input")));

    builder
      .click(driver.findElement(By.className("ymaps-2-1-77-searchbox-input__input")))
      .sendKeys("Санкт-Петербург")
      .sendKeys(Keys.ENTER)
      .build()
      .perform();

    Assertions.assertTrue(driver.findElements(By.className("address-list-item-name")).size() != 0);
    driver.quit();
  }
}
