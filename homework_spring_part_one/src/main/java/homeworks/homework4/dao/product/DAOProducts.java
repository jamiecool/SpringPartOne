package homeworks.homework4.dao.product;

import homeworks.homework4.dao.objects.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DAOProducts extends JpaRepository<Product, Integer> {
    public List<Product> findAllMax();
    public List<Product> findAllMin();
}
