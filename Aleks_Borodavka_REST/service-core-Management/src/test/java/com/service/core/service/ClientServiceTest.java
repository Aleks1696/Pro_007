package com.service.core.service;

import com.service.api.dto.ClientRecordDTO;
import com.service.api.request.GeneralRequest;
import com.service.api.request.parameters.ClientParametrs;
import com.service.core.dao.AccountRepository;
import com.service.core.dao.ClientRepository;
import com.service.core.dbConfig.TestDBConfig;
import com.service.core.domain.ClientAccount;
import com.service.core.domain.ClientRecord;
import com.service.core.domain.CourseRecord;
import com.service.core.exception.StandardServerException;
import com.service.core.service.client.ClientService;
import com.service.core.util.AccountUtil;
import com.service.core.util.ClientUtil;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
@EnableAutoConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
@EntityScan("com.service.core.domain")
@EnableJpaRepositories("com.service.core.dao")
@ComponentScan(basePackages = {
                      "com.service.core.service",
                      "com.service.core.util.mapper"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientServiceTest extends Assert {

    @Configuration
    @Import(TestDBConfig.class)
    static class Configure{

    }

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testCreateClientRecordPositive(){
        ClientParametrs clientParametrs = ClientUtil.createClientParameters();
        Long id = clientService.createClientRecord(ClientUtil.createClientParameters());

        ClientRecord clientRecord = clientRepository.findOne(id);
        assertNotNull(clientRecord);
        assertEquals(id, clientRecord.getId());
        assertEquals(clientParametrs.getName(), clientRecord.getName());
        assertEquals(clientParametrs.getSurname(), clientRecord.getSurname());
        assertEquals(clientParametrs.getEmail(), clientRecord.getEmail());
        assertEquals(clientParametrs.getPhoneNumber(), clientRecord.getPhoneNumber());
        assertNull(clientRecord.getAccount());
        assertThat(0, Matchers.is(clientRecord.getCourseRecord().size()));
    }

    @Test
    public void testCreateClientRecordNegative(){
        Long id = clientService.createClientRecord(ClientUtil.createClientParameters());

        ClientRecord clientRecord = clientRepository.findOne(id);
        assertNotEquals("Smth", clientRecord.getName());
        assertNotEquals("Smth", clientRecord.getSurname());
        assertNotEquals("Smth", clientRecord.getEmail());
        assertNotEquals("Smth", clientRecord.getPhoneNumber());

        assertNotSame(1, Matchers.is(clientRecord.getCourseRecord().size()));
    }

    @Test
    public void testDeleteClientRecordByIdPositive(){
        ClientRecord clientRecord = clientRepository.saveAndFlush(ClientUtil.createClientRecord());

        clientService.deleteClientRecord(clientRecord.getId());
        assertNull(clientRepository.findOne(clientRecord.getId()));
    }

    @Test(expected = StandardServerException.class)
    public void testDeleteClientRecordByIdNegative(){
        clientService.deleteClientRecord(ClientUtil.BAD_CLIENT_ID);
    }

    @Test
    public void testGetClientRecordByIdPositive(){
        ClientRecord clientRecord = clientRepository.saveAndFlush(ClientUtil.createClientRecord());

        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setClientId(clientRecord);
        clientAccount.setLogin("Test_Account");
        clientAccount.setPassword("Test_Account");
        accountRepository.saveAndFlush(clientAccount);

        clientRecord.setAccount(clientAccount);
        clientRepository.saveAndFlush(clientRecord);

        ClientRecordDTO clientRecordDTO = clientService.getClientRecordById(clientRecord.getId());

        assertNotNull(clientRecordDTO);
        assertEquals(clientRecord.getId(), clientRecordDTO.getId());
        assertEquals(clientRecord.getName(), clientRecordDTO.getName());
        assertEquals(clientRecord.getSurname(), clientRecordDTO.getSurname());
        assertEquals(clientRecord.getEmail(), clientRecordDTO.getEmail());
        assertEquals(clientRecord.getPhoneNumber(), clientRecordDTO.getPhoneNumber());
        assertEquals(clientRecord.getAccount().getId().toString(), clientRecordDTO.getAccount());

    }

    @Test(expected = StandardServerException.class)
    public void testGetClientRecordByIdNegative(){
        clientService.getClientRecordById(ClientUtil.BAD_CLIENT_ID);
    }

    @Test
    public void testGetAllClientsRecordsPositive(){
        ClientRecord record1 = clientRepository.saveAndFlush(ClientUtil.createClientRecord());
        ClientRecord record2 = clientRepository.saveAndFlush(ClientUtil.createClientRecord());
        List<ClientRecord> clientRecordList = new ArrayList<>();
        clientRecordList.add(record1);
        clientRecordList.add(record2);

        List<ClientRecordDTO> clientRecordDTOList = clientService.getAllClientsRecords();

        for (ClientRecordDTO recordDTO : clientRecordDTOList){
            for (ClientRecord clientRecord: clientRecordList){
                if (clientRecord.getId() == recordDTO.getId()){
                    assertEquals(clientRecord.getName(), recordDTO.getName());
                    assertEquals(clientRecord.getSurname(), recordDTO.getSurname());
                    assertEquals(clientRecord.getEmail(), recordDTO.getEmail());
                    assertEquals(clientRecord.getPhoneNumber(), recordDTO.getPhoneNumber());
                    assertEquals("Client account is not specified", recordDTO.getAccount());
                }
            }

        }
    }

    @Test
    public void testUpdateClientRecordPositive(){
        ClientRecord clientRecord = clientRepository.saveAndFlush(ClientUtil.createClientRecord());
        ClientParametrs updatedClientParameters = ClientUtil.updatedPrameters();

        clientService.updateClientRecord(
                new GeneralRequest<>(clientRecord.getId(), updatedClientParameters));

        ClientRecord result = clientRepository.findOne(clientRecord.getId());
        assertNotNull(result);
        assertEquals(updatedClientParameters.getName(), result.getName());
        assertEquals(updatedClientParameters.getSurname(), result.getSurname());
        assertEquals(updatedClientParameters.getEmail(), result.getEmail());
        assertEquals(updatedClientParameters.getPhoneNumber(), result.getPhoneNumber());
    }

    @Test(expected = StandardServerException.class)
    public void testUpdateClientRecordNegative(){
        clientService.updateClientRecord(
                new GeneralRequest<>(ClientUtil.BAD_CLIENT_ID, ClientUtil.updatedPrameters())
        );
    }






}
