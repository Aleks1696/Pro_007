package com.service.core.service.group;

import com.service.api.dto.GroupRecordDTO;
import com.service.api.request.GeneralRequest;
import com.service.api.request.parameters.GroupParametrs;

import java.util.List;

public interface GroupService {

    Long createGroupRecord(GroupParametrs createGroupRequest);

    void deleteGroupRecord(Long groupId);

    GroupRecordDTO getGroupRecordById(Long groupId);

    List<GroupRecordDTO> getAllGroupsOnCourse(Long courseId);

    void singClientToGroup(Long groupId, Long clientId);

    void updateGroupRecord(GeneralRequest<Long, GroupParametrs> updateGroupRequest);

}
