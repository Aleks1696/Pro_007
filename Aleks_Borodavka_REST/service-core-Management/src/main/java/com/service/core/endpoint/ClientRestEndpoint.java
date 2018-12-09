package com.service.core.endpoint;


import com.service.api.dto.ClientRecordDTO;
import com.service.api.endpoint.ClientEndpoint;
import com.service.api.request.parameters.ClientParametrs;
import com.service.api.request.GeneralRequest;
import com.service.api.response.GeneralResponse;
import com.service.core.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientRestEndpoint implements ClientEndpoint {

    private ClientService clientService;

    @Autowired
    public void ClientRestEndpoint(ClientService clientService) {
        this.clientService = clientService;
    }

    public GeneralResponse<Long> createClientRecord(
            @RequestBody GeneralRequest<Void, ClientParametrs> createRequest) {
        return new GeneralResponse<Long>(200L,
                clientService.createClientRecord(createRequest.getParameters()));
    }

    public GeneralResponse<Void> deleteClientRecord(@RequestParam Long id) {
        clientService.deleteClientRecord(id);
        return new GeneralResponse<Void>(200L, null);
    }

    public GeneralResponse<ClientRecordDTO> getClientRecordById(@RequestParam Long id) {
        return new GeneralResponse<ClientRecordDTO>(200L, clientService.getClientRecordById(id));
    }

    public GeneralResponse<List<ClientRecordDTO>> getAllClientsRecords() {
        return new GeneralResponse<List<ClientRecordDTO>>(200L, clientService.getAllClientsRecords());
    }

    public GeneralResponse<Void> updateClientRecord(
            @RequestBody GeneralRequest<Long, ClientParametrs> updateRequest) {
        clientService.updateClientRecord(updateRequest);
        return new GeneralResponse<Void>(200L, null);
    }


}
