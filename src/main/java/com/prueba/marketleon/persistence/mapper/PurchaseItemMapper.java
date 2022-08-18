package com.prueba.marketleon.persistence.mapper;

import com.prueba.marketleon.domain.Product;
import com.prueba.marketleon.domain.PurchaseItem;
import com.prueba.marketleon.persistence.entity.ComprasProducto;
import com.prueba.marketleon.persistence.entity.ComprasProductoPK;
import com.prueba.marketleon.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active"),

    })
    PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);
    List<PurchaseItem> toPurchaseItems(List<ComprasProducto> comprasProductos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true),
            @Mapping(target = "producto", ignore = true)
    })

    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);
    List<ComprasProducto> toComprasProductos(List<PurchaseItem> purchaseItems);


}
