package com.service.core.util.mapper;

import com.service.api.dto.GroupRecordDTO;
import com.service.core.domain.CourseRecord;
import com.service.core.domain.GroupRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupRecordMapper {

    //    @Mapping(source = "courseRecord", target = "courseId")
    List<GroupRecordDTO> groupRecordListToDTO(Collection<GroupRecord> groupRecordCollection);

    @Mapping(source = "courseRecord", target = "courseId")
    GroupRecordDTO groupRecordToDTO(GroupRecord groupRecord);

    default Long courseRecordToLong(CourseRecord courseRecord) {
        return courseRecord.getId();
    }


}
