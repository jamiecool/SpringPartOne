package homeworks.homework3.dao;

import homeworks.homework3.dao.data_objects.Customer;
import homeworks.homework3.dao.data_objects.Product;

import java.util.List;

public interface DAOService {
    List<Customer> getListCustomer();

    List<Product> getListProduct();

    void deleteProductByCustomerId(int customer_id,int product_id);

    List<Customer> getListCustomerByProductId(int product_id);

    List<Product> getListProductByCustomerId(int customer_id);

    void addCustomer(Customer customer);

    void addProduct(Product product);

}
