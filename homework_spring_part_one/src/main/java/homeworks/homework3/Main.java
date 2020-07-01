package homeworks.homework3;

import homeworks.homework3.services.DAOService;
import homeworks.homework3.services.DAOServiceImpl;
import homeworks.homework3.services.data.Customer;
import homeworks.homework3.services.data.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOService service = new DAOServiceImpl();
        Customer customer = new Customer("Pavel");
        Product product = new Product("Computer",10.5f);

        service.addCustomer(customer);
        service.addProduct(product);

        List<Product> products = service.getListProduct();
        System.out.println(products);

        List<Customer> customers = service.getListCustomer();
        System.out.println(customers);

    }
}
