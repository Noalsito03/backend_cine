package com.project.cine.service;

import com.project.cine.exception.GlobalExceptionHandler;
import com.project.cine.interfaces.IClienteService;
import com.project.cine.model.Cliente;
import com.project.cine.repository.ClienteRepository;
import com.project.cine.response.ObjectResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    private static final Logger LOG = LogManager.getLogger(ClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ObjectResponse obtenerClientes() {
        ObjectResponse objectResponse = new ObjectResponse();
        try {
            List<Cliente> reservaciones = clienteRepository.findAll();
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
