package Homework6.pages;

import Homework6.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainShopPage extends BasePage {

  @FindBy(id = "tbSrch")
  private WebElement searchField;

  @FindBy(id = "head-pick-point-address")
  private WebElement addressButton;

  @FindBy(className = "my-basket")
  private WebElement basketButton;

  public MainShopPage(WebDriver driver) {
    super(driver);
  }

  @Step(value = "click on the search button")
  public MainShopPage clickSearch() {
    searchField.click();
    return this;
  }

  @Step(value = "enter war and peace in the search bar")
  public MainShopPage enterText(String text) {
    searchField.sendKeys(text);
    return this;
  }

  @Step(value = "pressing the button {key}")
  public SearchPage clickKey(Keys key) {
    searchField.sendKeys(key);
    return new SearchPage(driver);
  }

  @Step(value = "pressing the button Addresses")
  public AddressesPage addressesSearch() {
    addressButton.click();
    return new AddressesPage(driver);
  }

  @Step(value = "go to basket")
  public BasketPage goToBasket() {
    basketButton.click();
    return new BasketPage(driver);
  }
}
