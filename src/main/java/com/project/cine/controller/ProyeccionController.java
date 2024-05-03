package com.project.cine.controller;

import com.project.cine.interfaces.IProyeccionService;
import com.project.cine.response.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyeccion-controller/")
public class ProyeccionController {

    @Autowired
    private IProyeccionService iProyeccionService;

    @GetMapping("/obtener")
    public ResponseEntity<ObjectResponse> obtenereProyecciones() {
        ObjectResponse response = iProyeccionService.obtenerProyecciones();
        if ("0".equals(Integer.toString(response.getCode()))) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(500).body(response);

    }
}
