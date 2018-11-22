package com.service.core.service;

import com.service.api.dto.RequisitionDTO;
import com.service.api.request.CreateRequisitionRequest;
import com.service.api.request.StatusRequisitionRequest;
import com.service.api.request.UpdateRequisitionRequest;
import com.service.core.dao.RequisitionRepository;
import com.service.core.domain.Requisition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.List;

@Service
public class RequisitionServiceImpl implements RequisitionService {

    private RequisitionRepository requisitionRepository;

    @Autowired
    public RequisitionServiceImpl(RequisitionRepository requisitionRepository) {
        this.requisitionRepository = requisitionRepository;
    }




    public Long create(CreateRequisitionRequest request) {
        Requisition requisition = new Requisition();
        requisition.setName(request.getName());
        requisition.setEmail(request.getEmail());
        requisition.setComment(request.getComment());
        requisition.setCreationDate(Calendar.getInstance().getTime());
        requisition.setStatusRequisitionRequest(request.getStatus());
        return requisitionRepository.saveAndFlush(requisition).getId();
    }

    public RequisitionDTO get(Long id) {
       Requisition requisition = requisitionRepository.findOne(id);
       if (requisition == null){
           throw new IllegalStateException();
       }
       RequisitionDTO requisitionDTO = new RequisitionDTO();
       requisitionDTO.setId(requisition.getId());
       requisitionDTO.setName(requisition.getName());
       requisitionDTO.setComment(requisition.getComment());
       requisitionDTO.setEmail(requisition.getEmail());
       return requisitionDTO;
    }

    public void update(UpdateRequisitionRequest request) {
Requisition requisition= requisitionRepository.findByIdEquals(request.getId());
if(request == null){
    throw new IllegalStateException();
}
        requisition.setName(request.getName());
        requisition.setEmail(request.getEmail());
        requisition.setComment(request.getComment());
        requisition.setCreationDate(Calendar.getInstance().getTime());
        requisition.setStatusRequisitionRequest(request.getStatus());
        requisitionRepository.saveAndFlush(requisition);
    }

    public void delete(long id) {
Requisition requisition = requisitionRepository.findByIdEquals(id);
if(requisition != null){
   requisitionRepository.delete(id);
}
    }

    public void changeStatus(Long id, StatusRequisitionRequest statusRequisitionRequest) {
        Requisition requisition = requisitionRepository.findByIdEquals(id);
        if(requisition == null){
            throw new IllegalStateException();
        }
        requisition.setStatusRequisitionRequest(statusRequisitionRequest);
        requisitionRepository.saveAndFlush(requisition);
    }

    public List<RequisitionDTO> getAll() {
        return null;
    }


}
