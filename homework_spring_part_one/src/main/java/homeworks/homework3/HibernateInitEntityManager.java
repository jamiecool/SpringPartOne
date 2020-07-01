package homeworks.homework3;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.File;

public class HibernateInitEntityManager {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            // Получаем фабрику менеджеров сущностей
            EntityManagerFactory factory = new Configuration()
                    .configure(/*"src/main/resources/hibernate.cfg.xml"*/new File("D:/GitRepository/LearnGeekBrains/hibernate.cfg.xml"))
                    .buildSessionFactory();
            // Из фабрики создаем EntityManager
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }
}
