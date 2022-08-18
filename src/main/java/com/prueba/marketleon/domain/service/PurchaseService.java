package com.prueba.marketleon.domain.service;

import com.prueba.marketleon.domain.Product;
import com.prueba.marketleon.domain.Purchase;
import com.prueba.marketleon.domain.repository.ProductRepository;
import com.prueba.marketleon.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return  purchaseRepository.getAll();
    }


    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId);
    }
    public Optional<Purchase> getPurchase(int purchaseId) {
        return purchaseRepository.getPurchase(purchaseId);
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public boolean delete(int purchaseId){
        return getPurchase(purchaseId).map(product -> {
            purchaseRepository.delete(purchaseId);
            return true;
        }).orElse(false);
    }


}
