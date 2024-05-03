package com.project.cine.controller;

import com.project.cine.interfaces.IClienteService;
import com.project.cine.response.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente-controller/")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @GetMapping("/obtener")
    public ResponseEntity<ObjectResponse> obtenerClientes() {
        ObjectResponse response = iClienteService.obtenerClientes();
        if ("0".equals(Integer.toString(response.getCode()))) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(500).body(response);

    }
}
