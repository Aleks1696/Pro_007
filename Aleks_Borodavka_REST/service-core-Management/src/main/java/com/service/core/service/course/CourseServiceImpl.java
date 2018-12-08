package com.service.core.service.course;


import com.service.api.dto.ClientRecordDTO;
import com.service.api.dto.CourseRecordDTO;
import com.service.api.request.GeneralRequest;
import com.service.api.request.parameters.CourseParametrs;
import com.service.core.dao.ClientRepository;
import com.service.core.dao.CourseRepository;
import com.service.core.domain.ClientRecord;
import com.service.core.domain.CourseRecord;
import com.service.core.exception.StandardServerException;
import com.service.core.util.mapper.ClientRecordMapper;
import com.service.core.util.mapper.CourseRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private ClientRepository clientRepository;
    private CourseRecordMapper courseRecordMapper;
    private ClientRecordMapper clientRecordMapper;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository,
                             ClientRepository clientRepository,
                             CourseRecordMapper courseRecordMapper,
                             ClientRecordMapper clientRecordMapper) {
        this.courseRepository = courseRepository;
        this.clientRepository = clientRepository;
        this.courseRecordMapper = courseRecordMapper;
        this.clientRecordMapper = clientRecordMapper;
    }


    @Override
    public Long createCourseRecord(CourseParametrs courseParametrs) {
        CourseRecord courseRecord = new CourseRecord();
        courseRecord.setTitle(courseParametrs.getTitle());
        courseRecord.setDescription(courseParametrs.getDescription());

        return courseRepository.saveAndFlush(courseRecord).getId();
    }

    @Override
    public void deleteCourseRecord(Long id) {
        CourseRecord courseRecord = courseRepository.findOne(id);
        if (courseRecord == null) {
            throw new StandardServerException("db.course.record.not.found",
                    String.format("Course record %s is not found", id));
        }
        courseRepository.delete(courseRecord.getId());
    }

    @Override
    public CourseRecordDTO getCourseById(Long id) {
        CourseRecord courseRecord = courseRepository.findOne(id);
        if (courseRecord == null) {
            throw new StandardServerException("db.course.record.not.found",
                    String.format("Course record %s is not found", id));
        }
        return courseRecordMapper.courseRecordToDTO(courseRecord);
    }

    @Override
    public List<CourseRecordDTO> getAllCourseRecords() {
        return courseRecordMapper.courseRecordToDTOList(courseRepository.findAll());
    }

    @Override
    public List<ClientRecordDTO> getAllClientRecordsOnCourse(Long courseId) {
        CourseRecord courseRecord = courseRepository.findOne(courseId);
        if (courseRecord == null) {
            throw new StandardServerException("db.course.record.not.found",
                    String.format("Course record %s is not found", courseId));
        }
        List<ClientRecord> clientRecordList = courseRecord.getClientRecordList();
        return clientRecordMapper.listOfRecordsToListOfRecordDTO(clientRecordList);
    }

    @Override
    public void signClientOnCourse(Long courseId, Long clientId) {
        CourseRecord courseRecord = courseRepository.findOne(courseId);
        ClientRecord clientRecord = clientRepository.findOne(clientId);
        if (courseRecord == null) {
            throw new StandardServerException("db.course.record.not.found",
                    String.format("Course record %s is not found", courseId));
        } else if (clientRecord == null) {
            throw new StandardServerException("db.client.record.not.found",
                    String.format("Client record %s is not found", clientId));
        }

        courseRecord.getClientRecordList().add(clientRecord);
        clientRecord.getCourseRecord().add(courseRecord);

        clientRepository.saveAndFlush(clientRecord);
        courseRepository.saveAndFlush(courseRecord);
    }

    @Override
    public void updateCourseRecord(GeneralRequest<Long, CourseParametrs> updateCourseRequest) {
        CourseRecord courseRecord = courseRepository.findOne(updateCourseRequest.getId());
        if (courseRecord == null) {
            throw new StandardServerException("db.course.record.not.found",
                    String.format("Course record %s is not found", updateCourseRequest.getId()));
        }

        courseRecord.setTitle(updateCourseRequest.getParameters().getTitle());
        courseRecord.setDescription(updateCourseRequest.getParameters().getDescription());
        courseRepository.saveAndFlush(courseRecord);
    }
}
