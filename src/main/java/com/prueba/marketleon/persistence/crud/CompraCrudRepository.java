package com.prueba.marketleon.persistence.crud;

import com.prueba.marketleon.persistence.entity.Compra;
import com.prueba.marketleon.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer>{
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
