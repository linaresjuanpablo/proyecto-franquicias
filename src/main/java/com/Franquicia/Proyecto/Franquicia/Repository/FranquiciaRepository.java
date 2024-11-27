package com.Franquicia.Proyecto.Franquicia.Repository;

import com.Franquicia.Proyecto.Franquicia.Entity.FranquiciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface FranquiciaRepository extends JpaRepository<FranquiciaEntity, Long > {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO franquicia.franquicia " +
            "(nit,nombre,direccion,ciudad,representanteLegal,actividadEconomica)" +
            " values (:nit, :nombre, :direccion, :ciudad, :representanteLegal, :actividadEconomica)",
            nativeQuery = true)
    int guardarFranquicia(@Param("nit")Integer nit,
                           @Param("nombre")String nombre,
                           @Param("direccion")String direccion,
                           @Param("ciudad")String ciudad,
                           @Param("representanteLegal")String representanteLegal,
                           @Param("actividadEconomica")String actividadEconomica);
}
