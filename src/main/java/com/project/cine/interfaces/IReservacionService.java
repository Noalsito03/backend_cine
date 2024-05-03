package com.project.cine.interfaces;

import com.project.cine.model.Reservacion;
import com.project.cine.response.ObjectResponse;

public interface IReservacionService {
    ObjectResponse obtenerReservaciones();

    ObjectResponse crearReservacion(Long idProyeccion, Long idCliente, Integer cantidadAsientos);

    ObjectResponse cancelarReservacion(Long idReservacion);
}
