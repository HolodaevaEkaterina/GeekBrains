package Homework6.pages;

import Homework6.BasePage;
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

  public MainShopPage clickSearch() {
    searchField.click();
    return this;
  }

  public MainShopPage enterText(String text) {
    searchField.sendKeys(text);
    return this;
  }

  public SearchPage clickKey(Keys key) {
    searchField.sendKeys(key);
    return new SearchPage(driver);
  }

  public AddressesPage addressesSearch() {
    addressButton.click();
    return new AddressesPage(driver);
  }

  public BasketPage goToBasket() {
    basketButton.click();
    return new BasketPage(driver);
  }
}
