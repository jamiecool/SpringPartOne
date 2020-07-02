package homeworks.homework2.product.service;

import homeworks.homework2.product.dao.Products;
import homeworks.homework2.product.dao.data_objects.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductsImpl implements ServiceProducts {

    @Autowired
    private Products products;

    //private List<Product> products = new ArrayList<>();

    /*public ServiceProductsImpl() {
        //Тестовое наполнение данными
        products.add(new Product(2,"computer", 20.5f));
        products.add(new Product(1,"monitor",22.5f));
    }*/

    @Override
    public List<Product> getProductsAll() {
        return products.getProducts();
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
            products.getProducts().add(product);
        } else {
            throw new RuntimeException("Такой товар уже есть в списке");
        }
    }

    private Product findProduct(int id) {
        for (Product p : products.getProducts()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }


    public String print(){
        String textProducts = null;
        for (Product p : products.getProducts()) {
            textProducts += p.toString() + "\n";
        }

        return textProducts;
    }
}
