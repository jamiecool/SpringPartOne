package homeworks.homework2.product;

import homeworks.homework2.product.data.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsImpl implements Products {
    private List<Product> products = new ArrayList<>();


    public ProductsImpl() {
        /*Тестовое наполнение данными*/
        products.add(new Product(2,"computer", 20.5f));
        products.add(new Product(1,"monitor",22.5f));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
