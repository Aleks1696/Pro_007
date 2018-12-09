package com.service.core.util.mapper;

import com.service.api.dto.ClientRecordDTO;
import com.service.core.domain.ClientAccount;
import com.service.core.domain.ClientRecord;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientRecordMapper {

    ClientRecordDTO recordToRecordDTO(ClientRecord clientRecord);

    List<ClientRecordDTO> listOfRecordsToListOfRecordDTO(Collection<ClientRecord> clientRecordCollection);

    default String clientAccountToString(ClientAccount clientAccount) {
        if (clientAccount == null) {
            return "Client account is not specified";
        }
        return clientAccount.getId().toString();
    }
}
