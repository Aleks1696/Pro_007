package com.service.api.endpoint;


import com.service.api.dto.RequisitionDTO;
import com.service.api.request.CreateRequisitionRequest;
import com.service.api.request.StatusRequisitionRequest;
import com.service.api.request.UpdateRequisitionRequest;
import com.service.api.responce.GeneralResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@SwaggerDefinition(
        info = @Info(description = "REST API",version = "1.0.0",title = "REST API"),
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes = SwaggerDefinition.Scheme.HTTPS
)

@Api(tags = "Requisitions REST Endpoint")
@RequestMapping("/api/requisitions")
public interface RequisitonsEndpoint {
    @ApiOperation(value = "Создание нового заявления")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    GeneralResponse<Long> createRequisition(CreateRequisitionRequest request);

    @ApiOperation(value = "Обновление статуса")
    @RequestMapping(value = "/changestatus",method = RequestMethod.PUT)
    void changesStatus(Long id, StatusRequisitionRequest statusRequisitionRequest);

    @ApiOperation(value = "Обновление заявления")
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    GeneralResponse<Void> updateRequisition(UpdateRequisitionRequest request);


    @ApiOperation(value = "Удаление заявления")
    @RequestMapping(value ="/delete",method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteRequisition(Long id);


    @ApiOperation(value = "Получение заявления по Id")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    GeneralResponse<RequisitionDTO> getRequisitionById(Long id);
//
//    @ApiOperation(value = "Получить все заявления")
//    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
//    GeneralResponse<List<RequisitionDTO>> getAll ();
//
//    @ApiOperation(value = "Получить все актуальное")
//    @RequestMapping(value = "/get", method = RequestMethod.GET)
//    GeneralResponse<List<RequisitionDTO>> getPage ();

    @ApiOperation(value = " Получить все аккуальные  ")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    GeneralResponse<List<RequisitionDTO>> getAll ();


}

