package com.service.core.service;

import com.service.api.dto.ClientRecordDTO;
import com.service.api.dto.CourseRecordDTO;
import com.service.api.request.GeneralRequest;
import com.service.api.request.parameters.CourseParametrs;
import com.service.core.dao.ClientRepository;
import com.service.core.dao.CourseRepository;
import com.service.core.dbConfig.TestDBConfig;
import com.service.core.domain.ClientRecord;
import com.service.core.domain.CourseRecord;
import com.service.core.exception.StandardServerException;
import com.service.core.service.course.CourseService;
import com.service.core.util.ClientUtil;
import com.service.core.util.CourseUtil;
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

import java.util.ArrayList;
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
public class CourseServiceTest extends Assert {

    @Configuration
    @Import(TestDBConfig.class)
    static class Configure{

    }

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testCreateCourseRecordPositive(){
        CourseParametrs parametrs = CourseUtil.createCourseParameters();
        Long id = courseService.createCourseRecord(parametrs);

        CourseRecord courseRecord = courseRepository.findOne(id);
        assertNotNull(courseRecord);
        assertEquals(parametrs.getTitle(), courseRecord.getTitle());
        assertEquals(parametrs.getDescription(), courseRecord.getDescription());
        assertEquals(0, courseRecord.getClientRecordList().size());
        assertEquals(0, courseRecord.getGroupRecordList().size());
    }

    @Test
    public void testDeleteCourseRecordPositive(){
        CourseRecord courseRecord = courseRepository.saveAndFlush(CourseUtil.createCourseRecord());

        courseService.deleteCourseRecord(courseRecord.getId());

        assertNull(courseRepository.findOne(courseRecord.getId()));
    }

    @Test(expected = StandardServerException.class)
    public void testDeleteCourseRecordNegative(){
        courseService.deleteCourseRecord(CourseUtil.BAD_COURSE_ID);
    }


    @Test
    public void testGetCourseByIdPositive(){
        CourseRecord courseRecord = courseRepository.saveAndFlush(
                CourseUtil.createCourseRecord());

        CourseRecordDTO recordDTO = courseService.getCourseById(courseRecord.getId());
        assertNotNull(recordDTO);
        assertEquals(courseRecord.getId(), recordDTO.getId());
        assertEquals(courseRecord.getTitle(), recordDTO.getTitle());
        assertEquals(courseRecord.getDescription(), recordDTO.getDescription());
    }

    @Test(expected = StandardServerException.class)
    public void testGetCourseByIdNegative(){
        courseService.getCourseById(CourseUtil.BAD_COURSE_ID);
    }

    @Test
    public void testGetAllCourseRecordsPositive(){
        CourseRecord record1 = courseRepository.saveAndFlush(CourseUtil.createCourseRecord());
        CourseRecord record2 = courseRepository.saveAndFlush(CourseUtil.createCourseRecord());
        List<CourseRecord> recordList = new ArrayList<>();
        recordList.add(record1);
        recordList.add(record2);

        List<CourseRecordDTO> courseRecordDTOList = courseService.getAllCourseRecords();

        for (CourseRecordDTO recordDTO : courseRecordDTOList){
            for (CourseRecord courseRecord : recordList){
                if (recordDTO.getId().equals(courseRecord.getId())){
                    assertEquals(courseRecord.getTitle(), recordDTO.getTitle());
                    assertEquals(courseRecord.getDescription(), recordDTO.getDescription());
                }
            }
        }
    }

    @Test
    public void testGetAllClientRecordsOnCoursePositive(){
        CourseRecord courseRecord = CourseUtil.createCourseRecord();

        ClientRecord record1 = clientRepository.saveAndFlush(ClientUtil.createClientRecord());
        ClientRecord record2 = clientRepository.saveAndFlush(ClientUtil.createClientRecord());
        List<ClientRecord> clientRecordList = new ArrayList<>();
        clientRecordList.add(record1);
        clientRecordList.add(record2);

        courseRecord.getClientRecordList().add(record1);
        courseRecord.getClientRecordList().add(record2);
        courseRepository.saveAndFlush(courseRecord);

        List<ClientRecordDTO> clientRecordDTOList =
                courseService.getAllClientRecordsOnCourse(courseRecord.getId());

        for (ClientRecordDTO clientRecordDTO : clientRecordDTOList){
            for (ClientRecord clientRecord : clientRecordList){
                if (clientRecordDTO.getId().equals(clientRecord.getId())){
                    assertEquals(clientRecord.getName(), clientRecordDTO.getName());
                    assertEquals(clientRecord.getSurname(), clientRecordDTO.getSurname());
                    assertEquals(clientRecord.getEmail(), clientRecordDTO.getEmail());
                    assertEquals(clientRecord.getPhoneNumber(), clientRecordDTO.getPhoneNumber());
                }
            }
        }
    }

    @Test
    public void testSignClientOnCoursePositive(){
        CourseRecord courseRecord = courseRepository.saveAndFlush(CourseUtil.createCourseRecord());
        ClientRecord clientRecord = clientRepository.saveAndFlush(ClientUtil.createClientRecord());

        courseService.signClientOnCourse(courseRecord.getId(), clientRecord.getId());

        CourseRecord result = courseRepository.findOne(courseRecord.getId());
        ClientRecord clientResult = clientRepository.findOne(clientRecord.getId());

        assertNotNull(result);
        assertEquals(clientRecord, result.getClientRecordList().get(0));
        assertEquals(courseRecord, clientResult.getCourseRecord().get(0));

    }

    @Test(expected = StandardServerException.class)
    public void testSignClientOnCourseNegative(){
        courseService.signClientOnCourse(CourseUtil.BAD_COURSE_ID, ClientUtil.BAD_CLIENT_ID);
    }

    @Test
    public void testUpdateCourseRecordPositive(){
        CourseParametrs updateParameters = CourseUtil.updatedCourseParameters();
        CourseRecord courseRecord = courseRepository.saveAndFlush(CourseUtil.createCourseRecord());

        courseService.updateCourseRecord(
                new GeneralRequest<>(courseRecord.getId(), updateParameters));

        CourseRecord result = courseRepository.findOne(courseRecord.getId());
        assertEquals(courseRecord.getId(), result.getId());
        assertEquals(updateParameters.getTitle(), result.getTitle());
        assertEquals(updateParameters.getDescription(), result.getDescription());
    }

    @Test(expected = StandardServerException.class)
    public void testUpdateCourseRecordNegative(){

        courseService.updateCourseRecord(
                new GeneralRequest<>(CourseUtil.BAD_COURSE_ID, CourseUtil.createCourseParameters())
        );
    }
}
