package util;


import entity.UserRegAuth;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
                try {
                    sessionFactory = new MetadataSources(registry)
                            .addAnnotatedClass(UserRegAuth.class)
                            .buildMetadata()
                            .buildSessionFactory();

                } catch (Exception ex) {

                }
            }
            catch (Exception ex) {

            }
        }
        return null;
    }
}
