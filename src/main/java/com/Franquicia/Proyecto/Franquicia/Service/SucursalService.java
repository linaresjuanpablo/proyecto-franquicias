package com.Franquicia.Proyecto.Franquicia.Service;

import com.Franquicia.Proyecto.Franquicia.Repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService{

    private final SucursalRepository sucursalRepository;

    @Autowired
    public SucursalService(SucursalRepository sucursalRepository){
        this.sucursalRepository = sucursalRepository;
    }

    public int guardarSucursal(String nombre,
                               String nitSucursal,
                               String telefono,
                               String direccion,
                               String ciudad){


        if (ciudad == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("No se puede agregar sucursal");
        }

        return sucursalRepository.guardarSucursal(nombre,nitSucursal,telefono,direccion,ciudad);
    }
}
