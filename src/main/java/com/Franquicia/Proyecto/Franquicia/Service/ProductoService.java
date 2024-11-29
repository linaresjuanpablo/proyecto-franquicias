package com.Franquicia.Proyecto.Franquicia.Service;

import com.Franquicia.Proyecto.Franquicia.Dto.StockProductoDto;
import com.Franquicia.Proyecto.Franquicia.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    @Transactional
    public void actualizarProducto(String nombre, String cantidad, String precio, Long id){
        int filasActualizadas = productoRepository.actualizarStock(nombre, cantidad, precio, String.valueOf(id));
        if(filasActualizadas == 0){
            throw new IllegalArgumentException("el producto no existe o no se pudo actualizar el stock");
        }
    }

    public List<StockProductoDto> obtenerProductos(Long id){
        List<Object[]> resultados = productoRepository.productoMayor(id);

        return resultados.stream()
                .map(obj -> new StockProductoDto(
                        (String) obj[0],
                        (String) obj[1],
                        (String) obj[2],
                        (String) obj[3],
                        (String) obj[4]
                ))
                .collect(Collectors.toList());
    }
}