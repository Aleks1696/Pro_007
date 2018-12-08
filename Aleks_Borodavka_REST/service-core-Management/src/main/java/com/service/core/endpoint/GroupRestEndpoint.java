package com.service.core.endpoint;

import com.service.api.dto.GroupRecordDTO;
import com.service.api.endpoint.GroupEndpoint;
import com.service.api.request.GeneralRequest;
import com.service.api.request.parameters.GroupParametrs;
import com.service.api.response.GeneralResponse;
import com.service.core.service.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupRestEndpoint implements GroupEndpoint {

    private GroupService groupService;

    @Autowired
    public GroupRestEndpoint(GroupService groupService) {
        this.groupService = groupService;
    }

    public GeneralResponse<Long> createGroupRecord(
            @RequestBody GeneralRequest<Void, GroupParametrs> createGroupRequest) {
        return new GeneralResponse<>(200L,
                groupService.createGroupRecord(createGroupRequest.getParameters()));
    }

    public GeneralResponse<Void> deleteGroupRecord(
            @RequestParam Long id) {
        groupService.deleteGroupRecord(id);
        return new GeneralResponse<>(200L, null);
    }

    public GeneralResponse<GroupRecordDTO> getGroupRecordById(
            @RequestParam Long id) {
        return new GeneralResponse<>(200L, groupService.getGroupRecordById(id));
    }

    public GeneralResponse<List<GroupRecordDTO>> getAllGroupsForToday(
            @RequestParam Long courseId) {
        return new GeneralResponse<>(200L, groupService.getAllGroupsOnCourse(courseId));
    }

    public GeneralResponse<Void> singClientToGroup(
            @RequestParam Long groupId, @RequestParam Long clientId) {
        groupService.singClientToGroup(groupId, clientId);
        return new GeneralResponse<>(200L, null);
    }

    public GeneralResponse<Void> updateGroupRecord(
            @RequestBody GeneralRequest<Long, GroupParametrs> updateGroupRequest) {
        groupService.updateGroupRecord(updateGroupRequest);
        return new GeneralResponse<>(200L, null);
    }

}
