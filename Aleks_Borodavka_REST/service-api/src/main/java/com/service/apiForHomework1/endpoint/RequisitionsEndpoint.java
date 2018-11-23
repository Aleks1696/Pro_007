package com.service.apiForHomework1.endpoint;

import com.service.apiForHomework1.dto.RequisitionDTO;
import com.service.apiForHomework1.request.CreateRequisitionRequest;
import com.service.apiForHomework1.response.GeneralResponse;
import com.service.apiForHomework1.types.RequisitionStatus;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@SwaggerDefinition(
        info = @Info(description = "REST API", version = "1.0.0", title = "REST API",
                contact = @Contact(name = "Borodavka Oleksandr",
                        url = "www.google.com",
                        email = "aleks.borodavka@ukr.net")),
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes = SwaggerDefinition.Scheme.HTTPS
)
@Api(tags = "Requisition Rest Endpoint")
@RequestMapping("apiForHomework1/requisitions")
public interface RequisitionsEndpoint {

    @ApiOperation(value = "Changing requisition status")
    @RequestMapping(value = "/changeStatus", method = RequestMethod.PUT)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success")
    })
    GeneralResponse<Void> changeRequisitionStatus(Long id, RequisitionStatus status);

    @ApiOperation(value = "Creating new requisition")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GeneralResponse<Long> createRequisition(CreateRequisitionRequest createRequisitionRequest);

    @ApiOperation(value = "Getting requisition by ID")
    @RequestMapping(value = "/getRequisitionById", method = RequestMethod.GET)
    GeneralResponse<RequisitionDTO> getRequisitionById(Long id);

    @ApiOperation(value = "Getting all actual requisitions")
    @RequestMapping(value = "/getAllRequisitions", method = RequestMethod.GET)
    GeneralResponse<List<RequisitionDTO>> getAllRequisitions();

    @ApiOperation(value = "Getting requisitions page")
    @RequestMapping(value = "/getRequisitionsPage", method = RequestMethod.GET)
    Page<?> getRequisitionsPage(Integer page, Integer amount);

}
