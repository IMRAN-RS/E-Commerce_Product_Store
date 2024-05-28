package dev.imran.product_service.Services;

import dev.imran.product_service.models.Category;
import dev.imran.product_service.models.Product;
import dev.imran.product_service.repositories.CategoryRepository;
import dev.imran.product_service.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("selfProductService")
public class selfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public selfProductService(ProductRepository productRepository
                                    , CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public Product CreateProduct(String title, String Description, double Price, String categoryTitle, String image) {

        Product product = new Product();
        product.setTitle(title);
        product.setDescription(Description);
        product.setPrice(Price);
        product.setImage(image);

        Category categoryFromDatabase = categoryRepository.findByTitle(categoryTitle);
        if(categoryFromDatabase == null) {
            Category newCategory = new Category();
            newCategory.setTitle(categoryTitle);
            categoryFromDatabase = newCategory;
//            categoryFromDatabase=categoryRepository.save(new Category());
        }
        product.setCategory(categoryFromDatabase);

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
