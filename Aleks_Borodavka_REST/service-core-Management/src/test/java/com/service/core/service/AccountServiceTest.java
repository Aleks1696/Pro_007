package com.service.core.service;

import com.service.api.request.parameters.AccountParametrs;
import com.service.api.request.parameters.ClientParametrs;
import com.service.core.dao.AccountRepository;
import com.service.core.dao.ClientRepository;
import com.service.core.dbConfig.TestDBConfig;
import com.service.core.domain.ClientAccount;
import com.service.core.domain.ClientRecord;
import com.service.core.service.account.AccountService;
import com.service.core.util.AccountUtil;
import com.service.core.util.ClientUtil;
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
public class AccountServiceTest {

    @Configuration
    @Import(TestDBConfig.class)
    static class Configure{

    }

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testCreateAccountPositive(){
        AccountParametrs parameters = AccountUtil.createSingleAccountParameters();

        ClientRecord clientRecord = clientRepository.saveAndFlush(ClientUtil.createClientRecord());
        parameters.setClientId(clientRecord.getId());

        Long id = accountService.createAccount(parameters);

        ClientAccount clientAccount = accountRepository.findOne(id);
        Assert.assertNotNull(clientAccount);
        Assert.assertEquals(parameters.getClientId(), clientAccount.getClientId().getId());
        Assert.assertEquals(parameters.getLogin(), clientAccount.getLogin());
        Assert.assertEquals(parameters.getPassword(), clientAccount.getPassword());
    }


}
