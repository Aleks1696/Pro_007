package com.web.dao;

import com.web.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Member,Long> {
}
