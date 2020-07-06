package homeworks.homework4.controllers;

import homeworks.homework4.service.product.ServiceProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private static ServiceProducts serviceProduct;


    @GetMapping(value = "/1")
    public String getAllProduct(Model model, @RequestParam(name = "min", required = false) boolean min,@RequestParam(name = "max", required = false) boolean max) {
        model.addAttribute("products", serviceProduct.getProductsAll(min,max));
        return "all_products_form";
    }
}
