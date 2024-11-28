package com.Franquicia.Proyecto.Franquicia.Repository;

import com.Franquicia.Proyecto.Franquicia.Entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}




