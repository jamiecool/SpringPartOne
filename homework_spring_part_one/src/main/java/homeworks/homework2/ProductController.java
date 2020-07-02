package homeworks.homework2;

import homeworks.homework2.product.service.ServiceProducts;
import homeworks.homework2.product.dao.data_objects.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ServiceProducts serviceProducts;

    @GetMapping(value = "/getProductById")
    public String getProductById(Model model, @RequestParam(name = "id") int id) {
        model.addAttribute("product", serviceProducts.getProductsById(id));
        return "product_form";
    }

    @GetMapping(value = "/allProduct")
    public String getAllProduct(Model model) {
        model.addAttribute("products", serviceProducts.getProductsAll());
        return "all_products_form";
    }

    @GetMapping(value = "/addProduct")
    public String getForm(Model uiModel){
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "add_product";
    }

    @PostMapping(value = "/addProduct")
    public String addProduct(Product product) {
        serviceProducts.addProduct(product);
        return "add_product";
    }
}
