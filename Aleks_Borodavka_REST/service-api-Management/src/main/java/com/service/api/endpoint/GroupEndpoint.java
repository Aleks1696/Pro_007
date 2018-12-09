package com.service.api.endpoint;

import com.service.api.dto.GroupRecordDTO;
import com.service.api.request.GeneralRequest;
import com.service.api.request.parameters.GroupParametrs;
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
@Api(tags = "Group Service")
@RequestMapping(value = "management/group")
public interface GroupEndpoint {

    @ApiOperation(value = "Create new group record")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Group record is created"),
            @ApiResponse(code = 400, message = "Wrong syntax",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GeneralResponse<Long> createGroupRecord(GeneralRequest<Void, GroupParametrs> createGroupRequest);


    @ApiOperation(value = "Delete group by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Group record is deleted"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteGroupRecord(Long id);

    @ApiOperation(value = "Read group by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Group record is returned"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error")
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    GeneralResponse<GroupRecordDTO> getGroupRecordById(Long id);


    @ApiOperation(value = "Get all actual groups for today")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - All actual groups are returned"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/getAll/byCourseID", method = RequestMethod.GET)
    GeneralResponse<List<GroupRecordDTO>> getAllGroupsForToday(Long courseId);


    @ApiOperation(value = "Sing new client to group")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Client is signed to group"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/sing/client", method = RequestMethod.PUT)
    GeneralResponse<Void> singClientToGroup(Long groupId, Long clientId);


    @ApiOperation(value = "Update group by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Group record is updated"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    GeneralResponse<Void> updateGroupRecord(GeneralRequest<Long, GroupParametrs> updateGroupRequest);
}
