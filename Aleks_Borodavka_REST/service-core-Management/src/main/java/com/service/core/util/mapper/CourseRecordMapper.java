package com.service.core.util.mapper;

import com.service.api.dto.CourseRecordDTO;
import com.service.core.domain.CourseRecord;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseRecordMapper {

    CourseRecordDTO courseRecordToDTO(CourseRecord courseRecord);

    List<CourseRecordDTO> courseRecordToDTOList(Collection<CourseRecord> courseRecordList);

}
