package com.service.core.sevice;

import com.service.api.dto.GroupDTO;
import com.service.api.requset.CreateGroupRequest;
import com.service.api.requset.UpdateGroupRequest;

import java.util.List;

public interface GroupService {
    Long create(CreateGroupRequest request);
    GroupDTO get (Long id);
    void update(UpdateGroupRequest request);
    void delete (Long id);
    List<GroupDTO> getAll ();
}
