package com.service.core.sevice;

import com.service.core.dao.GroupRepository;
import com.service.api.dto.GroupDTO;
import com.service.api.requset.CreateGroupRequest;
import com.service.api.requset.UpdateGroupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService {
    private GroupRepository groupRepository;
@Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Long create(CreateGroupRequest request) {
        return null;
    }

    public GroupDTO get(Long id) {
        return null;
    }

    public void update(UpdateGroupRequest request) {

    }

    public void delete(Long id) {

    }

    public List<GroupDTO> getAll() {
        return null;
    }
}
