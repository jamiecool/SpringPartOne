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

    @Override
    public List<Product> getProductsAll() {
        return products;
    }

    @Override
    public Product getProductsById(int id) {
        Product p = findProduct(id);

        if (p == null) {
            throw new RuntimeException("Товар отсутствует в списке товаров");
        }

        return p;
    }


    @Override
    public void addProduct(Product product) {
        if (findProduct(product.getId()) == null) {
            products.add(product);
        } else {
            throw new RuntimeException("Такой товар уже есть в списке");
        }
    }

    private Product findProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }


    public String print(){
        String textProducts = null;
        for (Product p : products) {
            textProducts += p.toString() + "\n";
        }

        return textProducts;
    }
}
