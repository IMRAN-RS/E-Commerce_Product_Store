package dev.imran.product_service.Services;
import dev.imran.product_service.models.Product;

import java.util.List;


public interface ProductService {

   public Product getSingleProduct(Long id);

    public Product CreateProduct(String title, String Description, double Price, String category, String image);


    public List<Product> getAllProducts();

}
