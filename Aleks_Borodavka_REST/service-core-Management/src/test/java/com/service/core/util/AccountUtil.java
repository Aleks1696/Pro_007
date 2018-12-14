package com.service.core.util;

import com.service.api.request.parameters.AccountParametrs;
import com.service.core.dao.ClientRepository;
import com.service.core.domain.ClientRecord;
import org.springframework.beans.factory.annotation.Autowired;
public class AccountUtil {


    public static AccountParametrs createSingleAccountParameters(){
        AccountParametrs accountParametrs = new AccountParametrs();
        accountParametrs.setLogin("Test");
        accountParametrs.setPassword("Test");
        return accountParametrs;
    }

}
