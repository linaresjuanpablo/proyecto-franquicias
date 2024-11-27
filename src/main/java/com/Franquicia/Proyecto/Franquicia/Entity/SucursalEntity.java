package com.Franquicia.Proyecto.Franquicia.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sucursal")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SucursalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nitSucursal")
    private Integer nitSucursal;

    @Column(name = "telefono")
    private  String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad")
    private String ciudad;



}
