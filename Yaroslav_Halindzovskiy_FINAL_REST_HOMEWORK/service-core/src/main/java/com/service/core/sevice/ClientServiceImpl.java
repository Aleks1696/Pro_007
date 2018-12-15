package com.service.core.sevice;

import com.service.core.dao.ClientRepository;
import com.service.api.dto.ClientDTO;
import com.service.api.requset.CreateClientRequest;
import com.service.api.requset.UpdateClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
@Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Long create(CreateClientRequest request) {
        return null;
    }

    public ClientDTO get(Long id) {
        return null;
    }

    public void update(UpdateClientRequest request) {

    }

    public void delete(Long id) {

    }

    public List<ClientDTO> getAll() {
        return null;
    }
}
