package com.service.core.dao;

import com.service.core.domain.Requisition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface RequisitionRepository extends JpaRepository<Requisition,Long> {

    Requisition findByIdEquals(Long id);
}
