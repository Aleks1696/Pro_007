package com.service.core.sevice;

import com.service.api.dto.ClientDTO;
import com.service.api.requset.CreateClientRequest;
import com.service.api.requset.UpdateClientRequest;

import java.util.List;

public interface ClientService {
    Long create(CreateClientRequest request);
    ClientDTO get (Long id);
    void update(UpdateClientRequest request);
    void delete (Long id);

    List<ClientDTO> getAll ();
}
