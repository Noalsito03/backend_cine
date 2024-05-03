package com.project.cine.service;

import com.project.cine.interfaces.IProyeccionService;
import com.project.cine.model.Proyeccion;
import com.project.cine.repository.ProyeccionRepository;
import com.project.cine.response.ObjectResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyeccionService implements IProyeccionService {

    private static final Logger LOG = LogManager.getLogger(ProyeccionService.class);

    @Autowired
    private ProyeccionRepository proyeccionRepository;

    @Override
    public ObjectResponse obtenerProyecciones() {
        ObjectResponse objectResponse = new ObjectResponse();
        try {
            List<Proyeccion> reservaciones = proyeccionRepository.findAll();
            objectResponse.setCode(0);
            objectResponse.setData(reservaciones);
        } catch (Exception e) {
            LOG.error(e);
            objectResponse.setCode(-1);
            objectResponse.setMessage("Error al obtener el cliente: " + e.getMessage());
        } finally {
            return objectResponse;
        }
    }

}
