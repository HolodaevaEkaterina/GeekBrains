package Homework6.pages;

import Homework6.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends BasePage {

  @FindBy(xpath = "//div[@class='cart-btn-wrap']/button[@class='c-btn-main-lg-v1 j-add-to-card']")
  private WebElement addButton;

  public BookPage(WebDriver driver) {
    super(driver);
  }

  @Step(value = "add item to basket")
  public BookPage addToBasket() {
    addButton.click();
    return this;
  }

  @Step(value = "go back to the previous page")
  public SearchPage back() {
    return new SearchPage(driver);
  }
}
