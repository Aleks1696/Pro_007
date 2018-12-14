package com.service.core.service;


import com.service.api.dto.GroupRecordDTO;
import com.service.api.request.GeneralRequest;
import com.service.api.request.parameters.GroupParametrs;
import com.service.core.dao.AccountRepository;
import com.service.core.dao.ClientRepository;
import com.service.core.dao.CourseRepository;
import com.service.core.dao.GroupRepository;
import com.service.core.dbConfig.TestDBConfig;
import com.service.core.domain.ClientAccount;
import com.service.core.domain.ClientRecord;
import com.service.core.domain.CourseRecord;
import com.service.core.domain.GroupRecord;
import com.service.core.exception.StandardServerException;
import com.service.core.service.group.GroupService;
import com.service.core.util.AccountUtil;
import com.service.core.util.ClientUtil;
import com.service.core.util.CourseUtil;
import com.service.core.util.GroupUtil;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
@EnableAutoConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
@EntityScan("com.service.core.domain")
@EnableJpaRepositories("com.service.core.dao")
@ComponentScan(basePackages = {
        "com.service.core.service",
        "com.service.core.util.mapper"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GroupServiceTest extends Assert {

    @Configuration
    @Import(TestDBConfig.class)
    static class Configure{

    }

    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testCreateGroupRecordPositive(){
        GroupParametrs parameters = GroupUtil.createGroupParameters();

        CourseRecord courseRecord = CourseUtil.createCourseRecord();
        courseRepository.saveAndFlush(courseRecord);
        parameters.setCourseId(courseRecord.getId());

        Long id = groupService.createGroupRecord(parameters);

        GroupRecord groupRecord = groupRepository.findOne(id);
        assertNotNull(groupRecord);
        assertEquals(id, groupRecord.getId());
        assertEquals(parameters.getTitle(), groupRecord.getTitle());
        assertEquals(parameters.getCourseId(), groupRecord.getCourseRecord().getId());

        assertNotNull(groupRecord.getBeginDate());
        assertNotNull(groupRecord.getEndDate());
    }

    @Test
    public void testDeleteGroupRecordPositive(){
        GroupRecord groupRecord = GroupUtil.createGroupRecord();

        CourseRecord courseRecord = CourseUtil.createCourseRecord();
        courseRepository.saveAndFlush(courseRecord);

        groupRecord.setCourseRecord(courseRecord);
        groupRepository.saveAndFlush(groupRecord);

        groupService.deleteGroupRecord(groupRecord.getId());

        assertNull(groupRepository.findOne(groupRecord.getId()));
    }

    @Test(expected = StandardServerException.class)
    public void testDeleteGroupRecordNegative(){
        groupService.deleteGroupRecord(GroupUtil.BAD_GROUP_ID);
    }

    @Test
    public void testGetGroupRecordByIdPositive(){
        GroupRecord groupRecord = GroupUtil.createGroupRecord();

        CourseRecord courseRecord = CourseUtil.createCourseRecord();
        courseRepository.saveAndFlush(courseRecord);

        groupRecord.setCourseRecord(courseRecord);
        groupRepository.saveAndFlush(groupRecord);

        GroupRecordDTO result = groupService.getGroupRecordById(groupRecord.getId());
        assertNotNull(result);
        assertEquals(groupRecord.getId(), result.getId());
        assertEquals(groupRecord.getTitle(), result.getTitle());
        assertNotNull(result.getBeginDate());
        assertNotNull(result.getEndDate());
        assertEquals(groupRecord.getCourseRecord().getId(), result.getCourseId());
    }

    @Test(expected = StandardServerException.class)
    public void testGetGroupRecordByIdNegative(){
        groupService.getGroupRecordById(GroupUtil.BAD_GROUP_ID);
    }

    @Test
    public void testGetAllGroupsOnCoursePositive(){
        CourseRecord courseRecord = CourseUtil.createCourseRecord();
        courseRepository.saveAndFlush(courseRecord);

        List<GroupRecord> groupRecordList = GroupUtil.createGroupRecordList();
        groupRecordList.forEach(groupRecord -> {
            groupRecord.setCourseRecord(courseRecord);
            groupRepository.saveAndFlush(groupRecord);
        });

        List<GroupRecordDTO> resultList = groupService.
                getAllGroupsOnCourse(courseRecord.getId());

        assertNotNull(resultList);
        for (GroupRecordDTO groupRecordDTO : resultList){
            for (GroupRecord record : groupRecordList){
                if (groupRecordDTO.getId().equals(record.getId())){
                    assertEquals(record.getTitle(), groupRecordDTO.getTitle());
                    assertNotNull(groupRecordDTO.getBeginDate());
                    assertNotNull(groupRecordDTO.getEndDate());
                    assertEquals(record.getCourseRecord().getId(), groupRecordDTO.getCourseId());
                }
            }
        }
    }

    @Test
    public void testSingClientToGroupPositive(){
        GroupRecord groupRecord = GroupUtil.createGroupRecord();

        CourseRecord courseRecord = CourseUtil.createCourseRecord();
        courseRepository.saveAndFlush(courseRecord);

        ClientRecord clientRecord = clientRepository.saveAndFlush(ClientUtil.createClientRecord());
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setClientId(clientRecord);
        accountRepository.saveAndFlush(clientAccount);

        groupRecord.setCourseRecord(courseRecord);
        groupRecord.getClientAccountList().add(clientAccount);
        groupRepository.saveAndFlush(groupRecord);
        clientAccount.getGroupRecord().add(groupRecord);
        clientRepository.saveAndFlush(clientRecord);

        GroupRecord result = groupRepository.findOne(groupRecord.getId());
        assertNotNull(result);
        assertEquals(clientAccount, result.getClientAccountList().get(0));
        assertEquals(clientAccount.getGroupRecord().get(0), result);

    }

    @Test(expected = StandardServerException.class)
    public void testSingClientToGroupNegative(){
        groupService.singClientToGroup(GroupUtil.BAD_GROUP_ID, ClientUtil.BAD_CLIENT_ID);
    }

    @Test
    public void testUpdateGroupRecordPositive() {
        GroupRecord groupRecord = GroupUtil.createGroupRecord();

        CourseRecord courseRecord = CourseUtil.createCourseRecord();
        courseRepository.saveAndFlush(courseRecord);

        groupRecord.setCourseRecord(courseRecord);
        GroupParametrs updatedParameters = GroupUtil.updatedGroupParameters();
        updatedParameters.setCourseId(courseRecord.getId());
        groupRepository.saveAndFlush(groupRecord);

        groupService.updateGroupRecord(
                new GeneralRequest<>(groupRecord.getId(), updatedParameters)
        );

        GroupRecord result = groupRepository.findOne(groupRecord.getId());
        assertNotNull(result);
        assertEquals(groupRecord.getId(), result.getId());
        assertEquals(groupRecord.getCourseRecord(), result.getCourseRecord());
        assertEquals(updatedParameters.getTitle(), result.getTitle());
        assertNotNull(result.getBeginDate());
        assertNotNull(result.getEndDate());
    }


}
