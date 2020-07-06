package homeworks.homework4.dao.product;

import homeworks.homework4.dao.objects.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOProducts extends JpaRepository<Product, Integer> {

}
