package hibernate.lesson9.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    /*
    SessionFactory - отвечает за установку соеденения с БД
  StandardServiceRegistry -  формируется из настроек которые мы обозначили в файле hibernate.cfg.xml

    * */
    private static final SessionFactory sessionFactory = build();
    private static StandardServiceRegistry registry;

    private static SessionFactory build(){
        registry = new StandardServiceRegistryBuilder()
                .configure("/hibernate/lesson9/hibernate.cfg.xml")
                .build();
        return new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

    }

    public static SessionFactory getFactory() {
        return sessionFactory;
    }
}
