package com.Franquicia.Proyecto.Franquicia.Controller;

import com.Franquicia.Proyecto.Franquicia.Dto.SucursalDto;
import com.Franquicia.Proyecto.Franquicia.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sucursales")

public class SucursalController {

    private final SucursalService sucursalService;

    @Autowired
    public SucursalController(SucursalService sucursalService){
        this.sucursalService = sucursalService;
    }

    @PostMapping
    public ResponseEntity<String> guardarSucursal(@RequestBody SucursalDto sucursal){
        sucursalService.guardarSucursal(
                sucursal.getNombre(),
                sucursal.getCiudad(),
                sucursal.getTelefono(),
                sucursal.getDireccion(),
                sucursal.getCiudad()
        );
        return ResponseEntity.ok("Sucursal guardada con exito");
    }

}
