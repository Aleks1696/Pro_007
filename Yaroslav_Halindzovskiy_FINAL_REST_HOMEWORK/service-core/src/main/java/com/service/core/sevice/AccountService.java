package com.service.core.sevice;

import com.service.core.domain.Account;
import com.service.api.requset.CreateAccountRequest;

import java.util.List;

public interface AccountService {
    Long create(CreateAccountRequest request);
    Account get (Long id);
    void update(CreateAccountRequest request);
    void delete (Long id);
    List<Account> getAll ();
}
