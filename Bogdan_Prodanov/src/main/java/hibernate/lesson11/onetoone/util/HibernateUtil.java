package hibernate.lesson11.onetoone.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    /**
     * SessionFactory - Отвечает за установку соединения к БД
     * StandardServiceRegistry - формируется из настроек
     * которые мы обозначили в файле hibernate.org.cfc.xml*/
    private static final SessionFactory sessionFactory = build();
    private static StandardServiceRegistry registry;

    private static SessionFactory build(){
        registry = new StandardServiceRegistryBuilder()
                .configure("/hibernate/lesson11/hibernate.cfg.xml")
                .build();
        return new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

    }

    public static SessionFactory getFactory() {
        return sessionFactory;
    }
}
