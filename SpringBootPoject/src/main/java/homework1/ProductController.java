package homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  private ProductRepository productRepository;

  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  //"/products/filtered?min_price=10"
  @GetMapping("/filtered")
  public List<Product> getProductsPriceGreater(Integer min_price) {
    return  productRepository.findByPriceGreaterThan(min_price);
  }

  //"/products/delete/1"
  @PostMapping("/delete/{id}")
  public void deleteById(@PathVariable Long id) {
    productRepository.deleteById(id);
  }
  //"/products/{id}/change_title?title=cow"
  @Transactional
  @PutMapping("/{id}/change_title")
  public void changeTitleById(@PathVariable Long id, @RequestParam String title) {
    productRepository.updateTitleById(title, id);
  }
}
