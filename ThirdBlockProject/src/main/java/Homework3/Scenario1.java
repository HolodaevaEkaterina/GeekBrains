package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scenario1 {

  //Поиск книг "Война и мир"
  public static void main(String[] args) {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver(options);

    driver.manage().window().maximize();
    driver.get("https://www.wildberries.ru/");
    WebElement searchBox = driver.findElement(By.id("tbSrch"));
    searchBox.sendKeys("война и мир");
    searchBox.sendKeys(Keys.ENTER);
  }
}
