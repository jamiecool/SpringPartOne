package homeworks.homework3.dao;

import homeworks.homework3.dao.dao_connect.HibernateInitEntityManager;
import homeworks.homework3.dao.data_objects.Customer;
import homeworks.homework3.dao.data_objects.Product;

import javax.persistence.EntityManager;
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
    public void deleteProductByCustomerId(int customer_id,int product_id) {
        beginTran();
        //Получаем клиента
        Customer customer = getCustomerById(customer_id);
        //получаем продукты клиента
        List<Product> products = customer.getProducts();

        for (Product p: products) {
            if (p.getProduct_id() == product_id){
                products.remove(p);
                break;
            }
        }
        em.merge(customer);
        commitTran();
    }

    private Customer getCustomerById(int customer_id) {
        return em.find(Customer.class,customer_id);
    }

    @Override
    public List<Customer> getListCustomerByProductId(int product_id) {
        beginTran();
        List<Customer> customers = em.find(Product.class, product_id).getCustomers();
        commitTran();
        return customers;
    }

    @Override
    public List<Product> getListProductByCustomerId(int customer_id) {
        beginTran();
        List<Product> products = getCustomerById(customer_id).getProducts();
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
