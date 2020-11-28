package Homework6.pages;

import Homework6.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage extends BasePage {

  @FindBy(className = "ymaps-2-1-77-searchbox-input__input")
  private WebElement citySearch;

  public AddressesPage(WebDriver driver) {
    super(driver);
  }

  public AddressesPage searchCity(String city) {
    citySearch.sendKeys(city);
    return this;
  }

  public AddressesPage clickKey(Keys key) {
    citySearch.sendKeys(key);
    return this;
  }

  public AddressesPage checkCityList() {
    Assertions.assertTrue(driver.findElements(By.className("address-list-item-name")).size() != 0);
    return this;
  }
}
