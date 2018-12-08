package com.service.core.service.account;

import com.service.api.request.parameters.AccountParametrs;

public interface AccountService {

    Long createAccount(AccountParametrs createAccountRequest);

}
