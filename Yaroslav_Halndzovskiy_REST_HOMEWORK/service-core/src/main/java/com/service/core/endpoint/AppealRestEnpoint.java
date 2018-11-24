package com.service.core.endpoint;


import com.service.api.dto.AppealDTO;
import com.service.api.dto.types.StatusAppeal;
import com.service.api.endpoint.AppealEndpoint;
import com.service.api.request.CreateAppealRequest;
import com.service.api.request.UpdateAppealRequest;
import com.service.api.response.GeneralResponse;
import com.service.core.service.AppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppealRestEnpoint implements AppealEndpoint {
    private AppealService appealService;
@Autowired
    public AppealRestEnpoint(AppealService appealService) {
        this.appealService = appealService;
    }

    public GeneralResponse<Long> createAppeal(@RequestBody CreateAppealRequest request) {
        return new GeneralResponse<Long>("200",appealService.create(request));
    }

    public GeneralResponse<AppealDTO> getAppealById(@RequestParam("id") Long id) {
        return new GeneralResponse<AppealDTO>("200",appealService.get(id));
    }

    public GeneralResponse<Void> updateAppeal(@RequestBody UpdateAppealRequest request) {
    appealService.update(request);
        return  new GeneralResponse<Void>("200",null);
    }

    public GeneralResponse<Void> deleteAppeal(@RequestParam("id") Long id) {
    appealService.delete(id);
        return new GeneralResponse<Void>("200",null);
    }

    public void changeStatus(@RequestParam Long id, StatusAppeal statusAppeal) {
appealService.changeStatus(id,statusAppeal);
    }

    public GeneralResponse<List<AppealDTO>> getAll() {
    appealService.getAll();

        return new GeneralResponse<List<AppealDTO>>("200",null);

    }
// Cупер костыль.
    public GeneralResponse<List<AppealDTO>> getPage(Integer page, Integer amount) {
int x;
        if (page!=1) {
            x = amount * page;
            amount++;
        }
        else x = page;

        while (amount!=0){
            appealService.getAll().add(appealService.get(Long.valueOf(x)));
            x++;
            amount--;
        }
        return new GeneralResponse<List<AppealDTO>>("200",null);
    }




}
