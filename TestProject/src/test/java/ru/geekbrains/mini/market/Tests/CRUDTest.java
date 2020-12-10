package ru.geekbrains.mini.market.Tests;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class CRUDTest {
  @Test
  public void getProductById_ExistId_IdTitle() {
    when()
      .get("http://localhost:8189/market/api/v1/products/1")
      .then()
      .statusCode(200)
      .and()
      .body("id", equalTo(1))
      .body("title", equalTo("Milk"));
  }

  @Test
  public void getProductById_NonexistId_400Code() {
    when()
      .get("http://localhost:8189/market/api/v1/products/19000")
      .then()
      .statusCode(400)
      .body("message", equalTo("there is no product with this id"));
  }

  @Test
  public void getProductsTest() {
    when()
      .get("http://localhost:8189/market/api/v1/products")
      .then()
      .statusCode(200)
      .and()
      .assertThat()
      .body("[0].title", equalTo("Milk"))
      .body("size", greaterThanOrEqualTo(0));
  }

  @Test
  public void createNewProduct_WithoutId_AddNewProduct() {

    Map<String, String> productMap = new HashMap<>();
    productMap.put("title", "Computer");
    productMap.put("price", "152852");
    productMap.put("categoryTitle", "Electronic");

    given()
      .contentType(ContentType.JSON)
      .accept(ContentType.JSON)
      .body(productMap)
      .when()
      .post("http://localhost:8189/market/api/v1/products")
      .then()
      .log().ifValidationFails(LogDetail.BODY)
      .body("title", equalTo("Computer"));
  }

  @Test
  public void createNewProduct_WithId_ThrowBadRequest() {

    Map<String, String> productMap = new HashMap<>();
    productMap.put("id", "10");
    productMap.put("title", "Computer");
    productMap.put("price", "152852");
    productMap.put("categoryTitle", "Electronic");

    given()
      .contentType(ContentType.JSON)
      .accept(ContentType.JSON)
      .body(productMap)
      .when()
      .post("http://localhost:8189/market/api/v1/products")
      .then()
      .statusCode(400)
      .body("message", equalTo("Id must be null for new entity"));
  }

  @Test
  public void modifyProduct_WithExistId_OK()
  {
    Map<String, String> productMap = new HashMap<>();
    productMap.put("id", "2");
    productMap.put("title", "Cat");
    productMap.put("price", "123456");
    productMap.put("categoryTitle", "Electronic");

    Map<String, String> productMapOld = new HashMap<>();
    productMapOld.put("id", "2");
    productMapOld.put("title", "Bread");
    productMapOld.put("price", "123456");
    productMapOld.put("categoryTitle", "Electronic");

    when()
      .get("http://localhost:8189/market/api/v1/products/2")
      .then()
      .statusCode(200)
      .and()
      .body("id", equalTo(2))
      .body("title", equalTo("Bread"));


    given()
      .contentType(ContentType.JSON)
      .accept(ContentType.JSON)
      .body(productMap)
      .when()
      .put("http://localhost:8189/market/api/v1/products")
      .then()
      .statusCode(200)
      .and()
      .body("title", equalTo("Cat"));

    when()
      .get("http://localhost:8189/market/api/v1/products/2")
      .then()
      .statusCode(200)
      .and()
      .body("id", equalTo(2))
      .body("title", equalTo("Cat"));

  }

  @Test
  public void modifyProduct_WithNonExistId_BadRequest()
  {
    Map<String, String> productMap = new HashMap<>();
    productMap.put("id", "15585");
    productMap.put("title", "Cat");
    productMap.put("price", "123456");
    productMap.put("categoryTitle", "Electronic");

    given()
      .contentType(ContentType.JSON)
      .accept(ContentType.JSON)
      .body(productMap)
      .when()
      .put("http://localhost:8189/market/api/v1/products")
      .then()
      .statusCode(400)
      .and()
      .body("message", equalTo("Product with id: 15585 doesn't exist"));
  }

  @Test
  public void modifyProduct_WithoutId_BadRequest()
  {
    Map<String, String> productMap = new HashMap<>();
    productMap.put("title", "Cat");
    productMap.put("price", "123456");
    productMap.put("categoryTitle", "Electronic");

    given()
      .contentType(ContentType.JSON)
      .accept(ContentType.JSON)
      .body(productMap)
      .when()
      .put("http://localhost:8189/market/api/v1/products")
      .then()
      .statusCode(400)
      .and()
      .body("message", equalTo("Id must be not null for new entity"));
  }

  @Test
  public void deleteById_WithId_OK()
  {
    when()
      .delete("http://localhost:8189/market/api/v1/products/3")
      .then()
      .statusCode(200);

    when()
      .get("http://localhost:8189/market/api/v1/products/3")
      .then()
      .statusCode(400)
      .body("message", equalTo("there is no product with this id"));
  }

  @Test
  public void deleteById_WithNonExistId_BadRequest()
  {
    when()
      .delete("http://localhost:8189/market/api/v1/products/1547852")
      .then()
      .statusCode(400)
      .body("message", equalTo("no such id exists"));
  }
}
