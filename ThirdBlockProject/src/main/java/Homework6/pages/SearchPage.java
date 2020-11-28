package Homework6.pages;

import Homework6.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.jupiter.api.*;

public class SearchPage extends BasePage {

  @FindBy(xpath = "//div[@class='searching-results-inner']/span")
  private WebElement searchingResults;

  @FindBy(id = "c2309872")
  private WebElement book;

  @FindBy(className = "my-basket")
  private WebElement basketButton;

  public SearchPage(WebDriver driver) {
    super(driver);
  }

  public BookPage openBook() {
    book.click();
    return new BookPage(driver);
  }

  public BasketPage openBasket() {
    basketButton.click();
    return new BasketPage(driver);
  }

  public SearchPage checkSearchingResult() {
    Assertions.assertTrue(Integer.parseInt(searchingResults.getText().replaceAll("\\D", "")) > 0);
    return this;
  }
}
