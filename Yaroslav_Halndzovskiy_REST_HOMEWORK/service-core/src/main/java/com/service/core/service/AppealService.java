package com.service.core.service;

import com.service.api.dto.AppealDTO;
import com.service.api.dto.types.StatusAppeal;
import com.service.api.request.CreateAppealRequest;
import com.service.api.request.UpdateAppealRequest;

import java.util.List;

public interface AppealService {
   Long create(CreateAppealRequest request);
   AppealDTO get (Long id);
   void update(UpdateAppealRequest request);
   void delete (Long id);
   void changeStatus (Long id, StatusAppeal statusAppeal);
   List<AppealDTO> getAll ();

}
