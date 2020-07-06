package homeworks.homework4.dao.product;


import homeworks.homework4.dao.connect.HibernateInitEntityManager;
import homeworks.homework4.dao.objects.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DAOProductsImpl  implements DAOProducts {
    /*@PersistenceContext
    private static final EntityManager em =  HibernateInitEntityManager.getEntityManager();*/
}
