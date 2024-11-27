package com.Franquicia.Proyecto.Franquicia.Service;

import com.Franquicia.Proyecto.Franquicia.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }
    public int guardarProducto(String nombre,
                               String cantidad,
                               String precio,
                               Long nitSucursal
                               ){

        return productoRepository.guardarProducto(nombre,cantidad,precio,nitSucursal);

    }

}
