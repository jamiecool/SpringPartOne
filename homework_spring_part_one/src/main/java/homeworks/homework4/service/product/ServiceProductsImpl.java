package homeworks.homework4.service.product;

import homeworks.homework4.dao.objects.Product;
import homeworks.homework4.dao.product.DAOProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProductsImpl implements ServiceProducts {
    @Autowired
    private static DAOProducts daoProducts;

    @Override
    @Transactional
    public List<Product> getProductsAll(boolean min, boolean max) {
        List<Product> products = daoProducts.findAll();
        //Если заведенных продуктов в базе нет, то добавим их.
        if (products == null || products.size() == 0) {
            //Добавляем тестовые данные
            addProductsToDB();
            products = daoProducts.findAll();
        }

        List<Product> resultProduct = null;

        if (min && !max) {
            resultProduct = daoProducts.findAllMin();
        } else if (!min && max) {
            resultProduct = daoProducts.findAllMax();
        } else if (min && max) {
            resultProduct = new ArrayList<>();
            resultProduct.add((Product) daoProducts.findAllMin());
            resultProduct.add((Product) daoProducts.findAllMax());
        } else {
            resultProduct = daoProducts.findAll();
        }
        return resultProduct;
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        daoProducts.save(product);
    }

    private void addProductsToDB() {
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            if (i % 5 == 0) {
                products.add(new Product("Computer " + i, i + 100 - 5));
            } else if (i % 4 == 0) {
                products.add(new Product("Computer " + i, i + 100 - 4));
            } else {
                products.add(new Product("Computer " + i, i + 100));
            }
        }

        daoProducts.saveAll(products);
    }
}
