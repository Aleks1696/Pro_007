package com.service.coreForHomework1.service;

import com.service.apiForHomework1.dto.RequisitionDTO;
import com.service.apiForHomework1.request.CreateRequisitionRequest;
import com.service.coreForHomework1.dao.RequisitionRepository;
import com.service.coreForHomework1.domain.Requisition;
import com.service.apiForHomework1.types.RequisitionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class RequisitionServiceImpl implements RequisitionService {

    private RequisitionRepository repository;

    @Autowired
    public RequisitionServiceImpl(RequisitionRepository repository) {
        this.repository = repository;
    }

    public void changeRequisitionStatus(Long id, RequisitionStatus status) {
        Requisition requisition = repository.findByIdEquals(id);
        if (requisition == null) {
            throw new IllegalStateException();
        }
        requisition.setStatus(status);
        repository.saveAndFlush(requisition);
    }

    public Long createRequisition(CreateRequisitionRequest request) {
        Requisition requisition = new Requisition();
        requisition.setName(request.getName());
        requisition.setEmail(request.getEmail());
        requisition.setPhoneNumber(request.getPhoneNumber());
        requisition.setComment(request.getComment());
        requisition.setStatus(RequisitionStatus.NEW);
        requisition.setCreationDate(Calendar.getInstance().getTime());
        return repository.saveAndFlush(requisition).getId();
    }

    public RequisitionDTO getRequisitionById(Long id) {
        Requisition requisition = repository.findByIdEquals(id);
        if (requisition == null) {
            throw new IllegalStateException();
        }
        RequisitionDTO requisitionDTO = new RequisitionDTO();
        requisitionDTO.setId(requisition.getId());
        requisitionDTO.setName(requisition.getName());
        requisitionDTO.setEmail(requisition.getEmail());
        requisitionDTO.setPhoneNumber(requisition.getPhoneNumber());
        requisitionDTO.setComment(requisition.getComment());
        requisitionDTO.setStatus(requisition.getStatus());
        requisitionDTO.setCreationDate(requisition.getCreationDate());
        return requisitionDTO;
    }

    public List<RequisitionDTO> getAllRequisitions() {
        List<RequisitionDTO> requisitionList = new ArrayList<RequisitionDTO>();
        requisitionList.addAll(repository.findAll());
        return requisitionList;
    }

    //как то странно и непонятно этот метод работает
    public Page<Requisition> getRequisitionsPage(Integer page, Integer amount) {
        Pageable pageRequest = new PageRequest(page, amount);
        Page<Requisition> pageOfRequisitions = repository.findAll(pageRequest);
        return pageOfRequisitions;
    }
}
