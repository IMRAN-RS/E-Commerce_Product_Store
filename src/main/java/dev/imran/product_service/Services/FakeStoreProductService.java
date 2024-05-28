package dev.imran.product_service.Services;

import dev.imran.product_service.Dtos.FakeStoreProductDto;
import dev.imran.product_service.models.Category;
import dev.imran.product_service.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreService")
public  class FakeStoreProductService implements ProductService{

    private  RestTemplate restTemplate;

    public  FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getSingleProduct(Long id){

        FakeStoreProductDto fakestoreProductDtos
                = restTemplate.getForObject(
                "https://fakestoreapi.com/products/1" + id, FakeStoreProductDto.class );

        Product product = new Product();
        product.setId(fakestoreProductDtos.getId());
        product.setTitle(fakestoreProductDtos.getTitle());
        product.setDescription(fakestoreProductDtos.getDescription());
        product.setImage(fakestoreProductDtos.getImage());

        Category category = new Category();
        category.setTitle(fakestoreProductDtos.getCategory());
        product.setCategory(category);

        return product;
    }


    @Override
    public Product CreateProduct(String title, String Description, double Price, String category, String image) {
        FakeStoreProductDto fakestoreProductDtos = new FakeStoreProductDto();

        fakestoreProductDtos.setTitle(title);
        fakestoreProductDtos.setDescription(Description);
        fakestoreProductDtos.setPrice(Price);
        fakestoreProductDtos.setCategory(category);
        fakestoreProductDtos.setImage(image);

        FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products", fakestoreProductDtos, FakeStoreProductDto.class);


        return response.toProduct();

    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] response = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakestoreProductDto : response){
            products.add(fakestoreProductDto.toProduct());
        }
        return products;
    }


}


