package dev.imran.product_service.Dtos;


import dev.imran.product_service.models.Category;
import dev.imran.product_service.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FakeStoreProductDto {

    private Long id;

    private String title;

    private String description;

    private double price;

    private String image;

    private String category;

    public Product toProduct() {
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setPrice(getPrice());
        product.setImage(getImage());

        Category category = new Category();
        category.setTitle(getCategory());
        product.setCategory(category);

        return product;

    }
}

