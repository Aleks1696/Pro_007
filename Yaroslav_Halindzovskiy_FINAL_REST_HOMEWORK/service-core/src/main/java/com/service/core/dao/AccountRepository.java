package com.service.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.service.core.domain.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
