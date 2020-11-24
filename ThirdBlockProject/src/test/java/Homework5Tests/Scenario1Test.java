package Homework5Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Scenario1Test {

  //Поиск книг "Война и мир"
  @Test
  public void scenario1Test() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    Actions builder = new Actions(driver);

    driver.get("https://www.wildberries.ru/");
    builder
      .moveToElement(driver.findElement(By.id("tbSrch")))
      .click()
      .sendKeys("война и мир")
      .sendKeys(Keys.ENTER)
      .build()
      .perform();

    Assertions.assertTrue(Integer.parseInt(driver.findElement(By.xpath("//div[@class='searching-results-inner']/span")).getText().replaceAll("\\D", "")) > 0);
    driver.quit();
  }
}
