package homeworks.homework3.services;

import homeworks.homework3.HibernateInitEntityManager;
import homeworks.homework3.services.data.Customer;
import homeworks.homework3.services.data.Product;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class DAOServiceImpl implements DAOService{
    private static final EntityManager em =  HibernateInitEntityManager.getEntityManager();

    private void addObjectToDB(Object object){
        beginTran();
        if (object instanceof Customer){
            em.persist((Customer) object);
        }else if (object instanceof Product){
           em.persist((Product) object);
        }else{
            rollbackTran();
            throw new RuntimeException("Object is not supported");
        }
        commitTran();
    }


    private void beginTran(){
        em.getTransaction().begin();
    }

    private void commitTran(){
        em.getTransaction().commit();
    }

    private void rollbackTran(){
        em.getTransaction().rollback();
    }

    @Override
    public List<Customer> getListCustomer() {
        beginTran();
        List<Customer> customers = em.createQuery("select c from Customer c",Customer.class).getResultList();
        commitTran();
        return customers;
    }

    @Override
    public List<Product> getListProduct() {
        beginTran();
        List<Product> products = em.createQuery("select p from Product p",Product.class).getResultList();
        commitTran();
        return products;
    }

    @Override
    public void deleteProductByCustomerId(int id) {

    }

    @Override
    public List<Customer> getListCustomerByProductId(int id) {
        beginTran();
        List<Customer> customers = em.find(Product.class,id).getCustomers();
        commitTran();
        return customers;
    }

    @Override
    public List<Product> getListProductByCustomerId(int id) {
        beginTran();
        List<Product> products = em.find(Customer.class,id).getProducts();
        commitTran();
        return products;
    }

    @Override
    public void addCustomer(Customer customer) {
        addObjectToDB(customer);
    }

    @Override
    public void addProduct(Product product) {
        addObjectToDB(product);
    }

}
