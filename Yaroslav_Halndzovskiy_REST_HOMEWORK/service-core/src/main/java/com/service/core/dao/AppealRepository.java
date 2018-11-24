package com.service.core.dao;

import com.service.core.domain.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface AppealRepository  extends  JpaRepository<Appeal,Long>{

    Appeal findByIdEquals(Long id);


}
