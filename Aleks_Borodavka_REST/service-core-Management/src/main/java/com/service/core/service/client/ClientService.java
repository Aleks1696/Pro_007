package com.service.core.service.client;

import com.service.api.request.parameters.ClientParametrs;
import com.service.api.request.GeneralRequest;
import com.service.api.dto.ClientRecordDTO;

import java.util.List;

public interface ClientService {

    Long createClientRecord(ClientParametrs createRequest);

    void deleteClientRecord(Long id);

    ClientRecordDTO getClientRecordById(Long id);

    List<ClientRecordDTO> getAllClientsRecords();

    void updateClientRecord(GeneralRequest<Long, ClientParametrs> updateRequest);

}
