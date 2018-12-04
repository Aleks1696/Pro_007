package com.service.api.endpoint;


import com.service.api.dto.ClientDTO;
import com.service.api.dto.CourseDTO;
import com.service.api.dto.GroupDTO;
import com.service.api.requset.*;
import com.service.api.response.GeneralResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@SwaggerDefinition(
        info = @Info(description = "REST API", version = "1.0.0", title = "REST API")
)
@Api(tags = "Management REST API ")
@RequestMapping("/api/management")
public interface ManagementEndpoint {

    @ApiOperation(value = "Create new account for client record")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GeneralResponse<Long> createAccount (CreateAccountRequest request);

    @ApiOperation(value = "Create new client record")
    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    GeneralResponse<Long> createClient (CreateClientRequest request);


    @ApiOperation(value = "Delete client by ID")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteClient (Long id);

    @ApiOperation(value = "Read client record by ID")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    GeneralResponse<ClientDTO> getClientById (Long id);

    @ApiOperation(value = "Read all client records")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    GeneralResponse<List<ClientDTO>> getAllClient ();

    @ApiOperation(value = "Update client by ID")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    GeneralResponse<Void> updateClient (UpdateClientRequest request);





    @ApiOperation(value = "Create new client course")
    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    GeneralResponse<Long> createCourse (CreateCourseRequest request);


    @ApiOperation(value = "Delete course by ID")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteCourse (Long id);


    @ApiOperation(value = "Read course record by ID")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    GeneralResponse<CourseDTO> getCourseById (Long id);

    @ApiOperation(value = "Read all course records")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    GeneralResponse<List<CourseDTO>> getAllCourse ();

    @ApiOperation(value = "Update course by ID")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    GeneralResponse<Void> updateCourse (UpdateCourseRequest request);

//    @ApiOperation(value = "Get registered clients on course")
//    @RequestMapping(value = "/getclients", method = RequestMethod.GET)
//    GeneralResponse<CourseDTO> getclients

    @ApiOperation(value = "Create new client group")
    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    GeneralResponse<Long> createGroup (CreateGroupRequest request);


    @ApiOperation(value = "Delete group by ID")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteGroup (Long id);


    @ApiOperation(value = "Read group record by ID")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    GeneralResponse<GroupDTO> getGroupById (Long id);

    @ApiOperation(value = "Read all groups records")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    GeneralResponse<List<GroupDTO>> getAllGroup ();

    @ApiOperation(value = "Update group by ID")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    GeneralResponse<Void> updateGroup (UpdateGroupRequest request);

}
