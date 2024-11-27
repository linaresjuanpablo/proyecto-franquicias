package com.Franquicia.Proyecto.Franquicia.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "franquicia")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FranquiciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nit")
    private String nit;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "representanteLegal")
    private String representanteLegal;

    @Column(name = "ActividadEconomica")
    private String actividadEconomica;
}
