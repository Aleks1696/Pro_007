package com.service.core.dao;

import com.service.core.domain.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<ClientAccount, Long> {


}
