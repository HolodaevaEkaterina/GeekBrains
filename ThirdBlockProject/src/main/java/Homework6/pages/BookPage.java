package Homework6.pages;

import Homework6.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends BasePage {

  @FindBy(xpath = "//div[@class='cart-btn-wrap']/button[@class='c-btn-main-lg-v1 j-add-to-card']")
  private WebElement addButton;

  public BookPage(WebDriver driver) {
    super(driver);
  }

  public BookPage addToBasket() {
    addButton.click();
    return this;
  }

  public SearchPage back() {
    return new SearchPage(driver);
  }
}
