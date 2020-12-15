package ru.geekbrains.mini.market;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.mini.market.entites.Category;
import ru.geekbrains.mini.market.entites.Product;
import ru.geekbrains.mini.market.repositories.CategoryRepository;
import ru.geekbrains.mini.market.service.CategoryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CategoryServiceTest {
  @Autowired
  private CategoryService categoryService;

  @MockBean
  private CategoryRepository categoryRepository;

  @Test
  public void findCategoryTest() {
    Category category = new Category();
    category.setTitle("Food");

    Product bread = new Product();
    bread.setId(1L);
    bread.setTitle("bread");
    bread.setPrice(100);
    bread.setCategory(category);

    List<Product> allProducts = new ArrayList<>(Arrays.asList(
      bread
    ));

    category.setProducts(allProducts);

    Mockito.doReturn(Optional.of(category))
      .when(categoryRepository)
      .findByTitle("Food");

    Category food = categoryService.findByTitle("Food").get();
    Assertions.assertNotNull(food);
    Assertions.assertEquals(allProducts, food.getProducts());
    Mockito.verify(categoryRepository, Mockito.times(1)).findByTitle(ArgumentMatchers.eq("Food"));
  }
}
