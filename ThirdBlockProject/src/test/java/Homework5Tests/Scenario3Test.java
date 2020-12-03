package Homework5Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Scenario3Test {

  //Проверка корзины
  @Feature("Old tests")
  @Test
  public void scenario3Test() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    Actions builder = new Actions(driver);

    driver.get("https://www.wildberries.ru/");
    builder
      .moveToElement(driver.findElement(By.className("my-basket")))
      .click()
      .build()
      .perform();

    Assertions.assertTrue(driver.findElement(By.className("i-empty-basket")).isEnabled());
    driver.quit();
  }
}
