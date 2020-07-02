package homeworks.homework2.product.service;

import homeworks.homework2.product.dao.dataobjects.Product;

import java.util.List;

public interface ServiceProducts {
    List<Product> getProductsAll();

    Product getProductsById(int id);

    void addProduct(Product product);
}
