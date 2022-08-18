package com.prueba.marketleon.persistence;

import com.prueba.marketleon.domain.Purchase;
import com.prueba.marketleon.domain.repository.PurchaseRepository;
import com.prueba.marketleon.persistence.crud.CompraCrudRepository;
import com.prueba.marketleon.persistence.entity.Compra;
import com.prueba.marketleon.persistence.entity.Producto;
import com.prueba.marketleon.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<Purchase> getPurchase(int purchaseId) {
        return compraCrudRepository.findById(purchaseId).map(compra -> mapper.toPurchase(compra));
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));

    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }

    @Override
    public void delete(int purchaseId) {
         compraCrudRepository.deleteById(purchaseId);
    }
}
