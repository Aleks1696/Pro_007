package com.service.core.service.client;

import com.service.api.request.parameters.ClientParametrs;
import com.service.api.request.GeneralRequest;
import com.service.api.dto.ClientRecordDTO;
import com.service.core.dao.ClientRepository;
import com.service.core.domain.ClientRecord;
import com.service.core.exception.StandardServerException;
import com.service.core.util.mapper.ClientRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ClientRecordMapper clientRecordMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository,
                             ClientRecordMapper clientRecordMapper) {
        this.clientRepository = clientRepository;
        this.clientRecordMapper = clientRecordMapper;
    }

    public Long createClientRecord(ClientParametrs createRequest) {
        ClientRecord clientRecord = new ClientRecord();
        clientRecord.setName(createRequest.getName());
        clientRecord.setSurname(createRequest.getSurname());
        clientRecord.setEmail(createRequest.getEmail());
        clientRecord.setPhoneNumber(createRequest.getPhoneNumber());
        return clientRepository.saveAndFlush(clientRecord).getId();
    }

    public void deleteClientRecord(Long id) {
        ClientRecord clientRecord = clientRepository.findByIdEquals(id);
        if (clientRecord == null) {
            throw new StandardServerException("db.client.record.not.found",
                    String.format("Client record %d is not found", id));
        }
        clientRepository.delete(id);
    }

    public ClientRecordDTO getClientRecordById(Long id) {
        ClientRecord clientRecord = clientRepository.findOne(id);
        if (clientRecord == null) {
            throw new StandardServerException("db.client.record.not.found",
                    String.format("Client record %d is not found", id));
        }
        return clientRecordMapper.recordToRecordDTO(clientRecord);
    }

    public List<ClientRecordDTO> getAllClientsRecords() {
        List<ClientRecord> clientRecordList = clientRepository.findAll();
        if (clientRecordList == null) {
            throw new StandardServerException("db.clients.record.list.not.found",
                    "Clients record list is not found in DB");
        }
        return clientRecordMapper.listOfRecordsToListOfRecordDTO(clientRecordList);
    }

    public void updateClientRecord(GeneralRequest<Long, ClientParametrs> updateRequest) {
        ClientRecord clientRecord = clientRepository.findOne(updateRequest.getId());
        if (clientRecord == null) {
            throw new StandardServerException("db.client.record.not.found",
                    String.format("Client record %d is not found", updateRequest.getId()));
        }
        clientRecord.setName(updateRequest.getParameters().getName());
        clientRecord.setSurname(updateRequest.getParameters().getSurname());
        clientRecord.setEmail(updateRequest.getParameters().getEmail());
        clientRecord.setPhoneNumber(updateRequest.getParameters().getPhoneNumber());
        clientRepository.saveAndFlush(clientRecord);
    }
}
