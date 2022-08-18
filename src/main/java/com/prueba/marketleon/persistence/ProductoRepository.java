package com.prueba.marketleon.persistence;

import com.prueba.marketleon.domain.Product;
import com.prueba.marketleon.domain.repository.ProductRepository;
import com.prueba.marketleon.persistence.crud.ProductoCrudRepository;
import com.prueba.marketleon.persistence.entity.Producto;
import com.prueba.marketleon.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos= productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
       Optional<List<Producto>> productos= productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<List<Product>> getCheapProducts(double price) {
        Optional<List<Producto>> productos = productoCrudRepository.findByPrecioVentaLessThan(price);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
         productoCrudRepository.deleteById(productId);
    }

    public ProductoCrudRepository getProductoCrudRepository() {
        return productoCrudRepository;
    }

    public void setProductoCrudRepository(ProductoCrudRepository productoCrudRepository) {
        this.productoCrudRepository = productoCrudRepository;
    }

    public ProductMapper getMapper() {
        return mapper;
    }

    public void setMapper(ProductMapper mapper) {
        this.mapper = mapper;
    }
}
