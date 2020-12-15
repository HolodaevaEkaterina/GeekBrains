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
import ru.geekbrains.mini.market.service.CategoryService;


@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControlletTest {
  @Autowired
  private MockMvc mvc;

  @MockBean
  private CategoryService categoryService;

  @Test
  public void getAllCategoriesTest() throws Exception {

    Category dishes = new Category();
    dishes.setId(1L);
    dishes.setTitle("Dishes");
    List<Category> allCategories = new ArrayList<>(Arrays.asList(
      dishes
    ));
    given(categoryService.findAll()).willReturn(allCategories);

    mvc.perform(get("/api/v1/categories")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$").isArray())
      .andExpect(jsonPath("$", hasSize(1)))
      .andExpect(jsonPath("$[0].title", is(allCategories.get(0).getTitle())));
  }

  @Test
  public void getCategoryByIdTest() throws Exception {

    Category dishes = new Category();
    dishes.setId(1L);
    dishes.setTitle("Dishes");

    Product product = new Product();
    product.setId(1L);
    product.setTitle("plate");
    product.setPrice(50);
    product.setCategory(dishes);

    ArrayList<Product> products = new ArrayList<>();
    products.add(product);

    dishes.setProducts(products);

    given(categoryService.getOneById(1L)).willReturn(Optional.of(dishes));

    mvc.perform(get("/api/v1/categories/1")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.products").isArray())
      .andExpect(jsonPath("$.products", hasSize(1)))
      .andExpect(jsonPath("$.title", is("Dishes")));
  }

  @Test
  public void getCategoryByIdTestNonExistingId() throws Exception {

    Category dishes = new Category();
    dishes.setId(1L);
    dishes.setTitle("Dishes");

    Product product = new Product();
    product.setId(1L);
    product.setTitle("plate");
    product.setPrice(50);
    product.setCategory(dishes);

    ArrayList<Product> products = new ArrayList<>();
    products.add(product);

    dishes.setProducts(products);

    mvc.perform(get("/api/v1/categories/50")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isNotFound())
      .andExpect(jsonPath("$.message", is("Unable to find category with id: 50")));
  }
}

