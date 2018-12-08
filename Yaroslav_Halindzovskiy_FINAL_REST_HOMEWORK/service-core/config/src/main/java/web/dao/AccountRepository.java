package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.domain.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
