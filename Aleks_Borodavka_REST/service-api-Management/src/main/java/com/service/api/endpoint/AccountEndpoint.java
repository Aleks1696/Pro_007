package com.service.api.endpoint;

import com.service.api.request.parameters.AccountParametrs;
import com.service.api.request.GeneralRequest;
import com.service.api.response.GeneralErrorResponse;
import com.service.api.response.GeneralResponse;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SwaggerDefinition(
        info = @Info(description = "Management API", version = "1.0.0", title = "Management API"),
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes = SwaggerDefinition.Scheme.HTTPS
)
@Api(tags = "Account Service", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, protocols = "https")
@RequestMapping(value = "management/account")
public interface AccountEndpoint {

    @ApiOperation(value = "Create new account for client record")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Account record is created"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GeneralResponse<Long> createAccount(GeneralRequest<Void, AccountParametrs> accountRequest);

}
