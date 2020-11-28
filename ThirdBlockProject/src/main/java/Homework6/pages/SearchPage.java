package Homework6.pages;

import Homework6.BasePage;
import io.qameta.allure.Step;
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

  @Step(value = "open the book page")
  public BookPage openBook() {
    book.click();
    return new BookPage(driver);
  }

  @Step(value = "go to basket")
  public BasketPage openBasket() {
    basketButton.click();
    return new BasketPage(driver);
  }

  @Step(value = "check that the list of search results is not empty")
  public SearchPage checkSearchingResult() {
    Assertions.assertTrue(Integer.parseInt(searchingResults.getText().replaceAll("\\D", "")) > 0);
    return this;
  }
}
