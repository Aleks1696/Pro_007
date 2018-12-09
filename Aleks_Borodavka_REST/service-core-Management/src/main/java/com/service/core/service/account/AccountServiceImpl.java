package com.service.core.service.account;

import com.service.api.request.parameters.AccountParametrs;
import com.service.core.dao.AccountRepository;
import com.service.core.dao.ClientRepository;
import com.service.core.domain.ClientAccount;
import com.service.core.domain.ClientRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private ClientRepository clientRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    public Long createAccount(AccountParametrs createAccountRequest) {
        ClientAccount account = new ClientAccount();
        account.setLogin(createAccountRequest.getLogin());
        account.setPassword(createAccountRequest.getPassword());

        Long accountID = accountRepository.saveAndFlush(account).getId();

        ClientRecord clientRecord = clientRepository.findOne(createAccountRequest.getClientId());
        ClientAccount clientAccount = accountRepository.findOne(accountID);

        //maps client with account and account with client
        clientRecord.setAccount(clientAccount);
        clientAccount.setClientId(clientRecord);
        clientRepository.saveAndFlush(clientRecord);
        accountRepository.saveAndFlush(clientAccount);
        return accountID;
    }
}
