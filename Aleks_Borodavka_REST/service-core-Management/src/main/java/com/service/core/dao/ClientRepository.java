package com.service.core.dao;

import com.service.core.domain.ClientRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientRecord, Long> {

    ClientRecord findByIdEquals(Long id);


}
