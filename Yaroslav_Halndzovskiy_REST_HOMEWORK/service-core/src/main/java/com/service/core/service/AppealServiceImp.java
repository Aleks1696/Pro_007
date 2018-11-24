package com.service.core.service;

import com.service.api.dto.AppealDTO;
import com.service.api.dto.types.StatusAppeal;
import com.service.api.request.CreateAppealRequest;
import com.service.api.request.UpdateAppealRequest;
import com.service.core.dao.AppealRepository;
import com.service.core.domain.Appeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class AppealServiceImp implements AppealService {
    private AppealRepository appealRepository;

    @Autowired
    public AppealServiceImp(AppealRepository appealRepository) {
        this.appealRepository = appealRepository;
    }

    public Long create(CreateAppealRequest request) {
        Appeal appeal = new Appeal();
        appeal.setName(request.getName());
        appeal.setComment(request.getComment());
        appeal.setCreationDate(Calendar.getInstance().getTime());
        appeal.setEmail(request.getEmail());
        appeal.setStatus(request.getStatus());
        return appealRepository.saveAndFlush(appeal).getId();
    }

    public AppealDTO get(Long id) {
        Appeal appeal = appealRepository.findOne(id);
        if (appeal == null) {
            throw new IllegalStateException();
        }
        AppealDTO appealDTO = new AppealDTO();
        appealDTO.setId(appeal.getId());
        appealDTO.setName(appeal.getName());
        appealDTO.setComment(appeal.getComment());
        appealDTO.setEmail(appeal.getEmail());

        return appealDTO;
    }

    public void update(UpdateAppealRequest request) {
        Appeal appeal = appealRepository.findByIdEquals(request.getId());
        if (appeal == null) {
            throw new IllegalStateException();
        }
        appeal.setName(request.getName());
        appeal.setComment(request.getComment());
        appeal.setCreationDate(Calendar.getInstance().getTime());
        appeal.setEmail(request.getEmail());
        appealRepository.saveAndFlush(appeal);
    }

    public void delete(Long id) {
        Appeal appeal = appealRepository.findByIdEquals(id);
        if (appeal != null) {
            appealRepository.delete(id);
        }

    }

    public void changeStatus(Long id, StatusAppeal statusAppeal) {
        Appeal appeal = appealRepository.findByIdEquals(id);
        if (appeal == null) {
            throw new IllegalStateException();
        }
        appeal.setStatus(statusAppeal);
        appealRepository.saveAndFlush(appeal);

    }

    public List<AppealDTO> getAll() {
        return null;
    }


}
