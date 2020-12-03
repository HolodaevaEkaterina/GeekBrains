package Homework6.pages;

import Homework6.BasePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {

  @FindBy(className = "i-empty-basket")
  private WebElement emptyBasket;

  @FindBy(xpath = "//div[@class='do-order-total-line total-count']/span")
  private WebElement itemsList;

  public BasketPage(WebDriver driver) {
    super(driver);
  }

  @Step(value = "check that the basket is empty")
  public BasketPage checkEmptyBasket() {
    Assertions.assertTrue(emptyBasket.isEnabled());
    return this;
  }

  @Step(value = "check that the basket is not empty")
  public BasketPage checkBasket() {
    Assertions.assertEquals(1, Integer.parseInt(itemsList.getText().replaceAll("\\D", "")));
    return this;
  }
}
