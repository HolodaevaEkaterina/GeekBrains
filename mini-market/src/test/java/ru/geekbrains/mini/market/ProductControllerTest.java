package ru.geekbrains.mini.market;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ru.geekbrains.mini.market.entites.Category;
import ru.geekbrains.mini.market.entites.Product;
import ru.geekbrains.mini.market.service.ProductService;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ProductService productService;

  @Test
  public void getAllProductsTest() throws Exception {

    Category electronic = new Category();
    electronic.setId(1L);
    electronic.setTitle("Electronic");

    Product computer = new Product();
    computer.setId(1L);
    computer.setTitle("Computer");
    computer.setPrice(100);
    computer.setCategory(electronic);

    List<Product> allProducts = new ArrayList<>(Arrays.asList(
      computer
    ));

    electronic.setProducts(allProducts);
    given(productService.getAllProducts()).willReturn(allProducts);

    mvc.perform(get("/api/v1/products")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$").isArray())
      .andExpect(jsonPath("$", hasSize(1)))
      .andExpect(jsonPath("$[0].title", is(allProducts.get(0).getTitle())));
  }

  @Test
  public void getProductByIdTest() throws Exception {

    Category electronic = new Category();
    electronic.setId(1L);
    electronic.setTitle("Electronic");

    Product computer = new Product();
    computer.setId(1L);
    computer.setTitle("Computer");
    computer.setPrice(100);
    computer.setCategory(electronic);

    List<Product> allProducts = new ArrayList<>(Arrays.asList(
      computer
    ));

    electronic.setProducts(allProducts);

    given(productService.getOneById(1L)).willReturn(Optional.of(computer));

    mvc.perform(get("/api/v1/products/1")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.price", is(100)))
      .andExpect(jsonPath("$.title", is("Computer")));
  }

  @Test
  public void getCategoryByIdTestNonExistingId() throws Exception {

    Category electronic = new Category();
    electronic.setId(1L);
    electronic.setTitle("Electronic");

    Product computer = new Product();
    computer.setId(1L);
    computer.setTitle("Computer");
    computer.setPrice(100);
    computer.setCategory(electronic);

    List<Product> allProducts = new ArrayList<>(Arrays.asList(
      computer
    ));

    electronic.setProducts(allProducts);

    mvc.perform(get("/api/v1/products/50")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isNotFound())
      .andExpect(jsonPath("$.message", is("Unable to find product with id: 50")));
  }
}
