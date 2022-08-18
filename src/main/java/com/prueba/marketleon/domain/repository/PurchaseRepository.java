package com.prueba.marketleon.domain.repository;

import com.prueba.marketleon.domain.Product;
import com.prueba.marketleon.domain.Purchase;
import com.prueba.marketleon.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();

    Optional<Purchase> getPurchase(int purchaseId);
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
    void delete(int purchaseId);
}
