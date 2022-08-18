package com.prueba.marketleon.domain.repository;

import com.prueba.marketleon.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<List<Product>> getCheapProducts(double price);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
