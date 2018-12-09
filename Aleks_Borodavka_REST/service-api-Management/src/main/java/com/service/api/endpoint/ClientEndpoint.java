package com.service.api.endpoint;

import com.service.api.dto.ClientRecordDTO;
import com.service.api.request.parameters.ClientParametrs;
import com.service.api.request.GeneralRequest;
import com.service.api.response.GeneralErrorResponse;
import com.service.api.response.GeneralResponse;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@SwaggerDefinition(
        info = @Info(description = "Management API", version = "1.0.0", title = "Management API"),
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes = SwaggerDefinition.Scheme.HTTPS
)
@Api(tags = "Client Service", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, protocols = "https")
@RequestMapping(value = "management/client")
public interface ClientEndpoint {

    @ApiOperation(value = "Create new client record")
    @ApiResponses(
            @ApiResponse(code = 200, message = "OK - Client record is created")
    )
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GeneralResponse<Long> createClientRecord(GeneralRequest<Void, ClientParametrs> createRequest);


    @ApiOperation(value = "Delete client record by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Client record is deleted"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteClientRecord(Long id);


    @ApiOperation(value = "Read client record by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Client record is returned"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    GeneralResponse<ClientRecordDTO> getClientRecordById(Long id);


    @ApiOperation(value = "Read all clients records")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - List of all client records is returned")
    })
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    GeneralResponse<List<ClientRecordDTO>> getAllClientsRecords();


    @ApiOperation(value = "Update client record")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Client record is updated"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    GeneralResponse<Void> updateClientRecord(GeneralRequest<Long, ClientParametrs> updateRequest);
}
