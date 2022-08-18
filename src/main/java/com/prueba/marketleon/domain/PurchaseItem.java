package com.prueba.marketleon.domain;

import com.prueba.marketleon.persistence.entity.Cliente;
import com.prueba.marketleon.persistence.entity.ComprasProducto;

import java.time.LocalDate;
import java.util.List;

public class PurchaseItem {
    private int productId;
    private int quantity;
    private double total;
    private boolean active;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
