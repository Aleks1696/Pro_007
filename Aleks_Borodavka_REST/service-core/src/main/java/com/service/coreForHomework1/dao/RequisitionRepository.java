package com.service.coreForHomework1.dao;

import com.service.coreForHomework1.domain.Requisition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitionRepository extends JpaRepository<Requisition, Long>,
        PagingAndSortingRepository<Requisition, Long> {

    Requisition findByIdEquals(Long id);

    Page<Requisition> findAll(Pageable pageRequest);

}
