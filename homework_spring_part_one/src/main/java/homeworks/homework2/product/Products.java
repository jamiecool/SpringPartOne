package homeworks.homework2.product;

import homeworks.homework2.product.data.Product;

import java.util.List;

public interface Products {
    List<Product> getProductsAll();

    Product getProductsById(int id);

    void addProduct(Product product);
}
