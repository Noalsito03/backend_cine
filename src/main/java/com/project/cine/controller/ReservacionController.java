package com.project.cine.controller;

import com.project.cine.interfaces.IReservacionService;
import com.project.cine.response.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/reservacion-controller/")
public class ReservacionController {

    @Autowired
    private IReservacionService iReservacionService;

    @GetMapping("/obtener")
    public ResponseEntity<ObjectResponse> obtenerReservaciones() {
        ObjectResponse response = iReservacionService.obtenerReservaciones();
        if ("0".equals(Integer.toString(response.getCode()))) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(500).body(response);

    }

    @PostMapping("/crear")
    public ResponseEntity<ObjectResponse> crearReservacion(
            @RequestParam(name = "idProyeccion", required = true) Long idProyeccion,
            @RequestParam(name = "idCliente", required = true) Long idCliente,
            @RequestParam(name = "cantidadAsientos", required = true) Integer cantidadAsientos
    ) {

        ObjectResponse response = iReservacionService.crearReservacion(Long.valueOf(idProyeccion), Long.valueOf(idCliente), cantidadAsientos);
        if ("0".equals(Integer.toString(response.getCode()))) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(500).body(response);

    }


    @PatchMapping("/cancelar/{idReservacion}")
    public ResponseEntity<ObjectResponse> crearReservacion(@PathVariable Long idReservacion) {

        ObjectResponse response = iReservacionService.cancelarReservacion(idReservacion);
        if ("0".equals(Integer.toString(response.getCode()))) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(500).body(response);

    }

}
