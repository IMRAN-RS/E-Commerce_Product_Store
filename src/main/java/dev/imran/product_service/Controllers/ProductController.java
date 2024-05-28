package dev.imran.product_service.Controllers;


import dev.imran.product_service.Dtos.CreateProductDto;
import dev.imran.product_service.Services.ProductService;
import dev.imran.product_service.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductDto productDto) {

        return productService.CreateProduct(
                productDto.getTitle(),
                String.valueOf(productDto.getCategory()),
                productDto.getPrice(),
                productDto.getImage(),
                productDto.getDescription()
        );
    }
    @GetMapping("/products")
    public List<Product> getAllProducts() {
       return productService.getAllProducts();
    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);

    }

    public void deleteProductById(Long id) {

    }

}
