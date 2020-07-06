package homeworks.homework4.service.product;

import homeworks.homework4.dao.objects.Product;

import java.util.List;

public interface ServiceProducts {

    List<Product> getProductsAll(boolean min, boolean max);

}
