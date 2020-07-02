package homeworks.homework2.product.dao;

import homeworks.homework2.product.dao.data_objects.Product;

import java.util.List;

public interface Products {

    public List<Product> getProducts();

    public void setProducts(List<Product> products);
}
