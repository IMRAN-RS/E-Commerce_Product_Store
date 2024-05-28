package dev.imran.product_service.Dtos;

import dev.imran.product_service.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter



public class CreateProductDto {

    private Long id;

    private String title;

    private String description;

    private double price;

    private String image;

    private Category category;

}
