package Homework6Tests.BaseTest;

import Homework7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

  protected EventFiringWebDriver driver;

  @BeforeAll
  public static void setUp() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  public void beforeEach() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");

    WebDriver chromeDriver = new ChromeDriver(options);
    driver = new EventFiringWebDriver(chromeDriver);
    driver.register(new CustomLogger());
    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.wildberries.ru/");
  }

  @AfterEach
  public void quitDriver() {
    driver.quit();
  }
}
