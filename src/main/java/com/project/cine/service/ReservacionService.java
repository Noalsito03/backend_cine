package com.project.cine.service;

import com.project.cine.interfaces.IReservacionService;
import com.project.cine.model.Cliente;
import com.project.cine.model.Proyeccion;
import com.project.cine.model.Reservacion;
import com.project.cine.repository.ClienteRepository;
import com.project.cine.repository.ProyeccionRepository;
import com.project.cine.repository.ReservacionRepository;
import com.project.cine.response.ObjectResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservacionService implements IReservacionService {

    private static final Logger LOG = LogManager.getLogger(ReservacionService.class);

    @Autowired
    private ReservacionRepository reservacionRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProyeccionRepository proyeccionRepository;

    @Override
    public ObjectResponse obtenerReservaciones() {
        ObjectResponse objectResponse = new ObjectResponse();
        try {
            List<Reservacion> reservaciones = reservacionRepository.findAll();
            objectResponse.setCode(0);
            objectResponse.setData(reservaciones);
        } catch (Exception e) {
            LOG.error(e);
            objectResponse.setCode(-1);
            objectResponse.setMessage("Error al obtener la reservacion: " + e.getMessage());
        } finally {
            return objectResponse;
        }
    }

    @Override
    public ObjectResponse crearReservacion(Long idProyeccion, Long idCliente, Integer cantidadAsientos) {
        ObjectResponse objectResponse = new ObjectResponse();
        try {
            Proyeccion proyeccion = proyeccionRepository.findById(idProyeccion)
                    .orElseThrow(() -> new RuntimeException("Proyeccion no encontrada con ID: " + idProyeccion));

            Cliente cliente = clienteRepository.findById(idCliente)
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + idCliente));

            Reservacion reservacion = new Reservacion();
            reservacion.setProyeccion(proyeccion);
            reservacion.setCliente(cliente);
            reservacion.setCantidadAsientos(cantidadAsientos);
            reservacion.setEstado(0);
            reservacionRepository.save(reservacion);
            objectResponse.setCode(0);
            objectResponse.setMessage("Se creo de manera satisfactoria.");
        } catch (Exception e) {
            LOG.error(e);
            objectResponse.setCode(-1);
            objectResponse.setMessage("Error al obtener la reservacion: " + e.getMessage());
        } finally {
            return objectResponse;
        }
    }

    @Override
    public ObjectResponse cancelarReservacion(Long idReservacion) {
        ObjectResponse objectResponse = new ObjectResponse();
        try {
            Reservacion reservacion = reservacionRepository.findById(idReservacion)
                    .orElseThrow(() -> new RuntimeException("Reservacion no encontrada con ID: " + idReservacion));
            reservacion.setEstado(1);
            reservacionRepository.save(reservacion);
            objectResponse.setCode(0);
            objectResponse.setMessage("Se cancelo de manera satisfactoria.");

        } catch (Exception e) {
            LOG.error(e);
            objectResponse.setCode(-1);
            objectResponse.setMessage("Error al obtener la reservacion: " + e.getMessage());
        } finally {
            return objectResponse;
        }
    }


}
