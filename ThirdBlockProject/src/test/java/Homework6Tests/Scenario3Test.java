package Homework6Tests;

import Homework6.pages.MainShopPage;
import Homework6Tests.BaseTest.BaseTest;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Scenario3Test  extends BaseTest {

  private static final Logger logger = LoggerFactory.getLogger(Scenario3Test.class);

  @Feature("Basket")
  //Проверка корзины
  @Test
  public void scenario3Test(){

    logger.info("Checking the basket");

    new MainShopPage(driver)
      .goToBasket()
      .checkEmptyBasket();
  }
}
