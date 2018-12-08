package com.service.core.service.group;

import com.service.api.dto.GroupRecordDTO;
import com.service.api.request.GeneralRequest;
import com.service.api.request.parameters.GroupParametrs;
import com.service.core.dao.AccountRepository;
import com.service.core.dao.ClientRepository;
import com.service.core.dao.CourseRepository;
import com.service.core.dao.GroupRepository;
import com.service.core.domain.ClientAccount;
import com.service.core.domain.ClientRecord;
import com.service.core.domain.CourseRecord;
import com.service.core.domain.GroupRecord;
import com.service.core.exception.InputException;
import com.service.core.exception.StandardServerException;
import com.service.core.util.mapper.GroupRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;
    private ClientRepository clientRepository;
    private AccountRepository accountRepository;
    private CourseRepository courseRepository;
    private GroupRecordMapper groupRecordMapper;

    //for parsing and checking date format
    DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy/MM/dd");


    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository,
                            ClientRepository clientRepository,
                            AccountRepository accountRepository,
                            CourseRepository courseRepository,
                            GroupRecordMapper groupRecordMapper) {
        this.groupRepository = groupRepository;
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.courseRepository = courseRepository;
        this.groupRecordMapper = groupRecordMapper;
    }

    @Override
    public Long createGroupRecord(GroupParametrs createGroupRequest) {
        GroupRecord groupRecord = new GroupRecord();
        try {
            groupRecord.setBeginDate(LocalDate.parse(createGroupRequest.getBeginDate(), parser));
            groupRecord.setEndDate(LocalDate.parse(createGroupRequest.getEndDate(), parser));
        } catch (DateTimeParseException e) {
            throw new InputException("client.date.format.mismatch",
                    "Wrong Begin/End date format (required: YYYY/MM/DD");
        }
        groupRecord.setCourseRecord(courseRepository.findOne(createGroupRequest.getCourseId()));
        groupRecord.setTitle(createGroupRequest.getTitle());

        return groupRepository.saveAndFlush(groupRecord).getId();
    }

    @Override
    public void deleteGroupRecord(Long groupId) {
        GroupRecord groupRecord = groupRepository.findOne(groupId);
        if (groupRecord == null) {
            throw new StandardServerException("db.group.record.not.found",
                    String.format("Group record %s is not found", groupId));
        }
        groupRepository.delete(groupRecord.getId());
    }

    @Override
    public GroupRecordDTO getGroupRecordById(Long groupId) {
        GroupRecord groupRecord = groupRepository.findOne(groupId);
        if (groupRecord == null) {
            throw new StandardServerException("db.group.record.not.found",
                    String.format("Group record %s is not found", groupId));
        }
        return groupRecordMapper.groupRecordToDTO(groupRecord);
    }

    @Override
    public List<GroupRecordDTO> getAllGroupsOnCourse(Long courseId) {
        CourseRecord courseRecord = courseRepository.findOne(courseId);
        if (courseRecord == null) {
            throw new StandardServerException("db.course.record.not.found",
                    String.format("Course record %s is not found", courseId));
        }

        LocalDate todaysDate = LocalDate.now();
        List<GroupRecord> listOfActiveGroupsForToday =
                groupRepository.findAllByBeginDateIsLessThanEqualAndEndDateGreaterThanEqual(
                        todaysDate, todaysDate);

//        List<GroupRecord> listOfActiveGroupsForToday = new ArrayList<>();
//        LocalDate todaysDate = LocalDate.now();
//        for (GroupRecord record : courseRecord.getGroupRecordList()){
//            if (record.getBeginDate().compareTo(todaysDate) <= 0 &&
//                record.getEndDate().compareTo(todaysDate) >= 0){
//                listOfActiveGroupsForToday.add(record);
//            }
//        }
        return groupRecordMapper.groupRecordListToDTO(listOfActiveGroupsForToday);
    }

    @Override
    public void singClientToGroup(Long groupId, Long clientId) {
        GroupRecord groupRecord = groupRepository.findOne(groupId);
        ClientRecord clientRecord = clientRepository.findOne(clientId);
        if (groupRecord == null) {
            throw new StandardServerException("db.group.record.not.found",
                    String.format("Group record %s is not found", groupId));
        } else if (clientRecord == null) {
            throw new StandardServerException("db.client.record.not.found",
                    String.format("Client record %s is not found", clientId));
        }
        ClientAccount clientAccount = clientRecord.getAccount();
        groupRecord.getClientAccountList().add(clientAccount);
        clientAccount.getGroupRecord().add(groupRecord);

        accountRepository.saveAndFlush(clientAccount);
        groupRepository.saveAndFlush(groupRecord);
        clientRepository.saveAndFlush(clientRecord);
    }

    @Override
    public void updateGroupRecord(GeneralRequest<Long, GroupParametrs> updateGroupRequest) {
        GroupRecord groupRecord = groupRepository.findOne(updateGroupRequest.getId());
        if (groupRecord == null) {
            throw new StandardServerException("db.group.record.not.found",
                    String.format("Group record %s is not found", updateGroupRequest.getId()));
        }
        try {
            groupRecord.setBeginDate(LocalDate.parse(
                    updateGroupRequest.getParameters().getBeginDate(), parser));
            groupRecord.setEndDate(LocalDate.parse(
                    updateGroupRequest.getParameters().getEndDate(), parser));
        } catch (DateTimeParseException e) {
            throw new InputException("client.date.format.mismatch",
                    "Wrong Begin/End date format (required: YYYY/MM/DD");
        }
        groupRecord.setTitle(updateGroupRequest.getParameters().getTitle());
        groupRecord.setCourseRecord(courseRepository.findOne(
                updateGroupRequest.getId()
        ));

        groupRepository.saveAndFlush(groupRecord);
    }
}
