package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Function;

//Поиск пунктов выдачи в Санкт Петербурге
public class Scenario2 {
  public static void main(String[] args)  {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver(options);

    driver.manage().window().maximize();
    driver.get("https://www.wildberries.ru/");
    WebElement addressButton = driver.findElement(By.id("head-pick-point-address"));
    addressButton.click();

    new WebDriverWait(driver, 80, 500)
      .until(ExpectedConditions.elementToBeClickable(By.className("ymaps-2-1-77-searchbox-input__input")));
    WebElement searchField = driver.findElement(By.className("ymaps-2-1-77-searchbox-input__input"));

    searchField.sendKeys("Санкт-Петербург");
    searchField.sendKeys(Keys.ENTER);
  }
}
