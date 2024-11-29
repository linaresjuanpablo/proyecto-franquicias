package com.Franquicia.Proyecto.Franquicia.Repository;

import com.Franquicia.Proyecto.Franquicia.Dto.StockProductoDto;
import com.Franquicia.Proyecto.Franquicia.Entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO franquicia.producto " +
            "(nombre, cantidad, precio, idSucursal) " +
            "VALUES (:nombre, :cantidad, :precio, " +
            "(SELECT id FROM franquicia.sucursal WHERE nitSucursal = :nitSucursal LIMIT 1))",
            nativeQuery = true)
    int guardarProducto(@Param("nombre") String nombre,
                        @Param("cantidad") String cantidad,
                        @Param("precio") String precio,
                        @Param("nitSucursal")Long nitSucursal

    );
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM franquicia.producto WHERE id = :id AND idSucursal = :idSucursal", nativeQuery = true)
    int eliminarProductoDeSucursal(@Param("id") Long id, @Param("idSucursal") Long idSucursal);

    @Transactional
    @Modifying
    @Query(value = "UPDATE franquicia.producto SET nombre = :nombre, cantidad = :cantidad, precio = :precio WHERE id = :id",
            nativeQuery = true)
    int actualizarStock(@Param("nombre")String nombre, @Param("cantidad")String cantidad, @Param("precio")String precio,
                        @Param("id")String id);

    @Transactional
    @Query(value = "SELECT p.nombre, p.precio, p.cantidad, s.nombreSucursal, f.nombreFranquicia " +
            "FROM franquicia.producto p " +
            "INNER JOIN franquicia.sucursal s ON s.id = p.idSucursal " +
            "INNER JOIN franquicia.franquicia f ON f.id = s.idFranquicia " +
            "WHERE p.cantidad = (SELECT MAX(p1.cantidad) FROM producto p1) AND f.id= :id ", nativeQuery = true)
    List<Object[]> productoMayor(@Param("id") Long  id);
}




