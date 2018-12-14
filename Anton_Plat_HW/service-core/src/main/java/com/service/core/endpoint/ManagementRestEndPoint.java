package com.service.core.endpoint;

import com.service.api.dto.ClientDTO;
import com.service.api.dto.CourseDTO;
import com.service.api.dto.GroupDTO;
import com.service.api.endpoint.ManagementEndpoint;
import com.service.api.request.*;
import com.service.api.response.GeneralResponse;

import java.util.List;

public class ManagementRestEndPoint implements ManagementEndpoint {


    public GeneralResponse<Long> createAccount(CreateAccountRequest request) {
        return null;
    }

    public GeneralResponse<Long> createClient(CreateClientRequest request) {
        return null;
    }

    public GeneralResponse<Void> deleteClient(Long id) {
        return null;
    }

    public GeneralResponse<ClientDTO> getClientById(Long id) {
        return null;
    }

    public GeneralResponse<List<ClientDTO>> getAllClient() {
        return null;
    }

    public GeneralResponse<Void> updateClient(UpdateClientRequest request) {
        return null;
    }

    public GeneralResponse<Long> createCourse(CreateCourseRequest request) {
        return null;
    }

    public GeneralResponse<Void> deleteCourse(Long id) {
        return null;
    }

    public GeneralResponse<CourseDTO> getCourseById(Long id) {
        return null;
    }

    public GeneralResponse<List<CourseDTO>> getAllCourse() {
        return null;
    }

    public GeneralResponse<Void> updateCourse(UpdateCourseRequest request) {
        return null;
    }

    public GeneralResponse<Long> createGroup(CreateGroupRequest request) {
        return null;
    }

    public GeneralResponse<Void> deleteGroup(Long id) {
        return null;
    }

    public GeneralResponse<GroupDTO> getGroupById(Long id) {
        return null;
    }

    public GeneralResponse<List<GroupDTO>> getAllGroup() {
        return null;
    }

    public GeneralResponse<Void> updateGroup(UpdateGroupRequest request) {
        return null;
    }
}
