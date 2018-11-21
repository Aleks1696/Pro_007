package com.service.api.endpoint;

import com.service.api.dto.AppealDTO;
import com.service.api.dto.types.StatusAppeal;
import com.service.api.request.CreateAppealRequest;
import com.service.api.request.UpdateAppealRequest;
import com.service.api.response.GeneralResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@SwaggerDefinition(
        info = @Info(description = "REST API", version = "1.0.0", title = "REST API"),
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes = SwaggerDefinition.Scheme.HTTPS
        )
@Api(tags = "Appeals REST Endpoint")
@RequestMapping("/api/appeals")
public interface AppealEndpoint {

    @ApiOperation(value = "Создание нового заявления")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GeneralResponse<Long> createAppeal(CreateAppealRequest request);

    @ApiOperation (value = "Получение заявления ")
    @RequestMapping (value = "/get" , method = RequestMethod.GET)
    GeneralResponse<AppealDTO> getAppealById (Long id);

    @ApiOperation (value = "Обновление завяления ")
    @RequestMapping (value = "/update", method = RequestMethod.PUT)
    GeneralResponse<Void> updateAppeal (UpdateAppealRequest request);

    @ApiOperation(value = "Удаление заявления ")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteAppeal(Long id);

    @ApiOperation(value = "Обновления статуса ")
    @RequestMapping(value = "/changestatus", method = RequestMethod.PUT)
    void changeStatus (Long id, StatusAppeal statusAppeal);

    @ApiOperation(value = " Получить все аккуальные  ")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    GeneralResponse<List<AppealDTO>> getAll ();
    @ApiOperation(value = " Получить все аккуальные  ")
    @RequestMapping(value = "/GetPage", method = RequestMethod.GET)
    GeneralResponse<List<AppealDTO>> getPage ();
}
