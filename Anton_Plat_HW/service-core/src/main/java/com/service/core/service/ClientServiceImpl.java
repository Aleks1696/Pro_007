package com.service.core.service;

import com.service.api.dto.ClientDTO;
import com.service.api.request.CreateClientRequest;
import com.service.api.request.UpdateClientRequest;
import com.service.core.dao.ClientRepository;
import com.service.core.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

@Autowired
public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Long create(CreateClientRequest request) {
        Client client = new Client();
        client.setName(request.getName());
        client.setSurname(request.getSurname());
        client.setEmail(request.getEmail());
        client.setPhone(request.getPhone());
        return clientRepository.saveAndFlush(client).getId();
    }

    public ClientDTO get(Long id) {
    Client client = clientRepository.findOne(id);
    if(client== null){
        System.out.println("Учетная запись %d не найдена");
    }
    ClientDTO clientDTO = new ClientDTO();
    clientDTO.setId(client.getId());
    clientDTO.setName(client.getName());
    clientDTO.setSurname(client.getSurname());
    clientDTO.setEmail(client.getEmail());
    clientDTO.setPhone(client.getPhone());
        return clientDTO;
    }

    public void update(UpdateClientRequest request) {
        Client client = clientRepository.findByIdEquals(request.getId());
        if(client== null){
            System.out.println("Учетная запись %d не найдена");
        }
        client.setName(request.getName());
        client.setSurname(request.getSurname());
        client.setEmail(request.getEmail());
        client.setPhone(request.getPhone());
         clientRepository.saveAndFlush(client);
    }

    public void delete(Long id) {
        Client client = clientRepository.findByIdEquals(id);
        if(client != null){
            System.out.println("Учетная запись %d не найдена");
        }
        clientRepository.delete(client);

    }
}
