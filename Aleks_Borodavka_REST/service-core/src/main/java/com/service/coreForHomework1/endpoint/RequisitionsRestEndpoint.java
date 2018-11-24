package com.service.coreForHomework1.endpoint;

import com.service.apiForHomework1.dto.RequisitionDTO;
import com.service.apiForHomework1.endpoint.RequisitionsEndpoint;
import com.service.apiForHomework1.request.CreateRequisitionRequest;
import com.service.apiForHomework1.response.GeneralResponse;
import com.service.apiForHomework1.types.RequisitionStatus;
import com.service.coreForHomework1.domain.Requisition;
import com.service.coreForHomework1.service.RequisitionService;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequisitionsRestEndpoint implements RequisitionsEndpoint {

    private RequisitionService requisitionService;

    @Autowired
    public RequisitionsRestEndpoint(RequisitionService requisitionService) {
        this.requisitionService = requisitionService;
    }

    public GeneralResponse<Void> changeRequisitionStatus(@RequestParam("id") Long id,
                                                         @RequestParam("status") RequisitionStatus status) {
        requisitionService.changeRequisitionStatus(id, status);
        return new GeneralResponse<Void>("200", null);
    }

    public GeneralResponse<Long> createRequisition(
            @RequestBody CreateRequisitionRequest createRequisitionRequest) {
        return new GeneralResponse<Long>("200", requisitionService.createRequisition(createRequisitionRequest));
    }

    public GeneralResponse<RequisitionDTO> getRequisitionById(@RequestParam("id") Long id) {
        return new GeneralResponse<RequisitionDTO>("200", requisitionService.getRequisitionById(id));
    }

    public GeneralResponse<List<RequisitionDTO>> getAllRequisitions() {
        return new GeneralResponse<List<RequisitionDTO>>("200", requisitionService.getAllRequisitions());
    }

    public Page<Requisition> getRequisitionsPage(
            @RequestParam("pageNumber") Integer page, @RequestParam("amount") Integer amount) {
        return requisitionService.getRequisitionsPage(page, amount);
    }
}
