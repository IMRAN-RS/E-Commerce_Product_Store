package dev.imran.product_service.repositories;

import dev.imran.product_service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
     Product  save(Product entity);
}
