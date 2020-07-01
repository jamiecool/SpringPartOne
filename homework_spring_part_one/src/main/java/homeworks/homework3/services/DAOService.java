package homeworks.homework3.services;

import homeworks.homework3.services.data.Customer;
import homeworks.homework3.services.data.Product;

import java.util.List;

public interface DAOService {
    List<Customer> getListCustomer();

    List<Product> getListProduct();

    void deleteProductByCustomerId(int id);

    List<Customer> getListCustomerByProductId(int id);

    List<Product> getListProductByCustomerId(int id);

    void addCustomer(Customer customer);

    void addProduct(Product product);

    void customerBuyProduct();
}
