package com.service.core.service;

import com.service.api.dto.ClientDTO;
import com.service.api.request.CreateClientRequest;
import com.service.api.request.UpdateClientRequest;

public interface ClientService {
    Long create(CreateClientRequest request);

    ClientDTO get(Long id);

    void update(UpdateClientRequest request);

    void delete(Long id);
}
