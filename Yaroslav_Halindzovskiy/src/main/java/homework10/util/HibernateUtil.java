package homework10.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = build();
    private static StandardServiceRegistry registry;

   private static SessionFactory build() {
        registry = new StandardServiceRegistryBuilder()
                .configure("homework10/hibernate.cfg.xml")
        .build();
return new MetadataSources(registry).buildMetadata().buildSessionFactory();

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
