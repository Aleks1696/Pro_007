package com.service.core.sevice;

import com.service.core.dao.AccountRepository;
import com.service.core.domain.Account;
import com.service.api.requset.CreateAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
@Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long create(CreateAccountRequest request) {
        return null;
    }

    public Account get(Long id) {
        return null;
    }

    public void update(CreateAccountRequest request) {

    }

    public void delete(Long id) {

    }

    public List<Account> getAll() {
        return null;
    }
}
