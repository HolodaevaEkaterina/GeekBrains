package Homework6Tests;

import Homework6.pages.MainShopPage;
import Homework6Tests.BaseTest.BaseTest;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class  Scenario4Test extends BaseTest {

  private static final Logger logger = LoggerFactory.getLogger(Scenario4Test.class);

  //Добавление элемента в корзину
  @Feature("Basket")
  @Test
  public void scenario4Test() {

    logger.info("Adding the book \"War and Peace\" to the cart");

    new MainShopPage(driver)
      .clickSearch()
      .enterText("война и мир")
      .clickKey(Keys.ENTER)
      .openBook()
      .addToBasket()
      .back()
      .openBasket()
      .checkBasket();
  }
}
