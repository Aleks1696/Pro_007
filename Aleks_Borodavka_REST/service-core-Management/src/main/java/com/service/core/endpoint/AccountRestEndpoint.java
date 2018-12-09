package com.service.core.endpoint;

import com.service.api.endpoint.AccountEndpoint;
import com.service.api.request.parameters.AccountParametrs;
import com.service.api.request.GeneralRequest;
import com.service.api.response.GeneralResponse;
import com.service.core.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestEndpoint implements AccountEndpoint {

    private AccountService accountService;

    @Autowired
    public AccountRestEndpoint(AccountService accountService) {
        this.accountService = accountService;
    }

    public GeneralResponse<Long> createAccount(
            @RequestBody GeneralRequest<Void, AccountParametrs> createAccountRequest) {
        return new GeneralResponse<Long>(200L,
                accountService.createAccount(createAccountRequest.getParameters()));
    }
}
