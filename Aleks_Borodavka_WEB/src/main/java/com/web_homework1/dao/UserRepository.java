package com.web_homework1.dao;

import com.web_homework1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByLoginAndPasswordEquals(String login, String password);

    User findByLogin (String login);

}
