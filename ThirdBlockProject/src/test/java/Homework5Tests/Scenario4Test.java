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

import java.util.concurrent.TimeUnit;

public class Scenario4Test {

  //Добавление элемента в корзину
  @Test
  public void scenario4Test() throws InterruptedException {
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

    new WebDriverWait(driver, 80, 500)
      .until(ExpectedConditions.visibilityOf(driver.findElement(By.id("c2309872"))));

    builder
      .moveToElement(driver.findElement(By.id("c2309872")))
      .click()
      .build()
      .perform();

    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    builder
      .click(driver.findElement(By.xpath("//div[@class='cart-btn-wrap']/button[@class='c-btn-main-lg-v1 j-add-to-card']")))
      .build()
      .perform();

    driver.navigate().back();
    builder
      .click(driver.findElement(By.className("my-basket")))
      .build()
      .perform();

    Assertions.assertEquals(1, Integer.parseInt(driver.findElement(By.xpath("//div[@class='do-order-total-line total-count']/span")).getText().replaceAll("\\D", "")));
    driver.quit();
  }
}
