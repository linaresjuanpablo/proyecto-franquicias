package com.Franquicia.Proyecto.Franquicia.Repository;

import com.Franquicia.Proyecto.Franquicia.Entity.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface SucursalRepository extends JpaRepository<SucursalEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO franquicia.sucursal " +
            "(nombre,nitSucursal,telefono,direccion, ciudad, idFranquicia)" +
            " values (:nombre,:nitSucursal,:telefono,:direccion,:ciudad," +
            "(select id from franquicia where ciudad = :ciudad LIMIT 1))",
            nativeQuery = true)
    int guardarSucursal(@Param("nombre")String nombre,
                        @Param("nitSucursal")String nitSucursal,
                        @Param("telefono")String telefono,
                        @Param("direccion")String direccion,
                        @Param("ciudad")String ciudad);

}






