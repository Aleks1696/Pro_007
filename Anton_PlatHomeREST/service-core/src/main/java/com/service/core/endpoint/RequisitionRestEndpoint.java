package com.service.core.endpoint;

import com.service.api.dto.RequisitionDTO;
import com.service.api.endpoint.RequisitonsEndpoint;
import com.service.api.request.CreateRequisitionRequest;
import com.service.api.request.StatusRequisitionRequest;
import com.service.api.request.UpdateRequisitionRequest;
import com.service.api.responce.GeneralResponse;
import com.service.core.service.RequisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequisitionRestEndpoint implements RequisitonsEndpoint {


 private   RequisitionService requisitionService;


    @Autowired
    public RequisitionRestEndpoint(RequisitionService requisitionService) {
        this.requisitionService = requisitionService;
    }




    public GeneralResponse<Long> createRequisition(@RequestBody CreateRequisitionRequest request) {
        return new GeneralResponse<Long>("200",requisitionService.create(request));
    }

    public void changesStatus(@RequestParam Long id, StatusRequisitionRequest statusRequisitionRequest) {
requisitionService.changeStatus(id,statusRequisitionRequest);
    }

    public GeneralResponse<Void> updateRequisition(UpdateRequisitionRequest request) {
        requisitionService.update(request);
        return new GeneralResponse<Void>("200", null);
    }

    public GeneralResponse<Void> deleteRequisition(Long id) {
        requisitionService.delete(id);
        return new GeneralResponse<Void>("200", null);
    }

    public GeneralResponse<RequisitionDTO> getRequisitionById(@RequestParam("id") Long id) {
        return new GeneralResponse<RequisitionDTO>("200",requisitionService.get(id));
    }

    public GeneralResponse<List<RequisitionDTO>> getAll() {

        return new GeneralResponse<List<RequisitionDTO>>("200",null);

    }
}
