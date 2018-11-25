package web.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(com.web.dao)

public class DBConfig {


    @Value("${hibernate.dialect}")
    private String HIBERNATE_DIALECT;
    @Value("${hibernate.show.sql}")
    private String HIBERNATE_SHOW_SQL;
    @Value("${hibernate.hbm2ddl.auto}")
    private String HIBERNATE_HBM2DDL_AUTO;
    @Value("${entity.manager.packages.to.scan}")
    private String PACKAGES_TO_SCAN;
}
