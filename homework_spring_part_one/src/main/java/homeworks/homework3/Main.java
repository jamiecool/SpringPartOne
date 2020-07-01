package homeworks.homework3;

import homeworks.homework3.services.DAOService;
import homeworks.homework3.services.DAOServiceImpl;
import homeworks.homework3.services.data.Customer;
import homeworks.homework3.services.data.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    private static DAOService service = new DAOServiceImpl();

    public static void main(String[] args) {
        initDataAuto();


        printAllData();
    }

    private static void printAllData() {
        List<Product> products = service.getListProduct();
        System.out.println(products);

        List<Customer> customers = service.getListCustomer();
        System.out.println(customers);
    }

    private static void initData() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            Customer customer = null;
            try {
                customer = new Customer(bf.readLine());
                service.addCustomer(customer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 3; i++) {
            Product product = null;
            try {
                product = new Product(bf.readLine(), Float.parseFloat(bf.readLine()));
                service.addProduct(product);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void initDataAuto() {
        for (int i = 0; i < 3; i++) {
            Customer customer = new Customer("Pavel" + i);
            service.addCustomer(customer);
        }

        for (int i = 0; i < 3; i++) {
            Product product = new Product("Computer" + i, 10.5f + i + 6);
            service.addProduct(product);
        }
    }
}
