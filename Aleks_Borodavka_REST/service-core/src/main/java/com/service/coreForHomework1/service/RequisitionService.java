package com.service.coreForHomework1.service;

import com.service.apiForHomework1.dto.RequisitionDTO;
import com.service.apiForHomework1.request.CreateRequisitionRequest;
import com.service.apiForHomework1.types.RequisitionStatus;
import com.service.coreForHomework1.domain.Requisition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RequisitionService {

    void changeRequisitionStatus(Long id, RequisitionStatus status);

    Long createRequisition(CreateRequisitionRequest request);

    RequisitionDTO getRequisitionById(Long id);

    List<RequisitionDTO> getAllRequisitions();

    Page<Requisition> getRequisitionsPage(Integer page, Integer amount);

}
