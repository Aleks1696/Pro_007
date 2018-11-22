package com.service.core.service;

import com.service.api.dto.RequisitionDTO;
import com.service.api.request.CreateRequisitionRequest;
import com.service.api.request.StatusRequisitionRequest;
import com.service.api.request.UpdateRequisitionRequest;
import com.service.core.domain.Requisition;

import java.util.List;

public interface RequisitionService {
    Long create(CreateRequisitionRequest request);
    RequisitionDTO get(Long id);

    void update(UpdateRequisitionRequest request);
    void delete(long id);
    void changeStatus(Long id,StatusRequisitionRequest statusRequisitionRequest);
    List<RequisitionDTO> getAll();
}
