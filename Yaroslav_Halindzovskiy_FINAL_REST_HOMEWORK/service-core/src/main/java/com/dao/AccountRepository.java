package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.domain.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
