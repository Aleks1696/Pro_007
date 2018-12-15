package com.service.core.util;

import com.service.api.request.parameters.ClientParametrs;
import com.service.core.dao.CourseRepository;
import com.service.core.domain.ClientAccount;
import com.service.core.domain.ClientRecord;
import com.service.core.domain.CourseRecord;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientUtil {

    public static ClientParametrs createClientParameters(){
        ClientParametrs clientParametrs = new ClientParametrs();
        clientParametrs.setName("Test");
        clientParametrs.setSurname("Test");
        clientParametrs.setEmail("Test");
        clientParametrs.setPhoneNumber("Test");
        return clientParametrs;
    }

    public static Long BAD_CLIENT_ID = 56789012L;

    public static ClientRecord createClientRecord(){
        ClientRecord clientRecord = new ClientRecord();
        clientRecord.setName("Test_ClientRecord");
        clientRecord.setSurname("Test_ClientRecord");
        clientRecord.setEmail("Test_ClientRecord");
        clientRecord.setPhoneNumber("Test_ClientRecord");

        return clientRecord;
    }

    public static ClientParametrs updatedPrameters(){
        ClientParametrs clientParametrs = new ClientParametrs();
        clientParametrs.setName("Test_Updated");
        clientParametrs.setSurname("Test_Updated");
        clientParametrs.setEmail("Test_Updated");
        clientParametrs.setPhoneNumber("Test_Updated");
        return clientParametrs;
    }
}
