package com.Franquicia.Proyecto.Franquicia.Service;

import com.Franquicia.Proyecto.Franquicia.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public  void eliminarProducto(Long id, Long idSucursal){
        int filasEliminadas = productoRepository.eliminarProductoDeSucursal(id, idSucursal);
        if (filasEliminadas == 0){
            throw new IllegalArgumentException("El producto no pertenece a la sucursal o no existe");
        }

    }
}

