package com.service.core.dao;

import com.service.core.domain.GroupRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<GroupRecord, Long> {

    List<GroupRecord> findAllByBeginDateIsLessThanEqualAndEndDateGreaterThanEqual(
            LocalDate currentDate1, LocalDate currentDate2);

}
