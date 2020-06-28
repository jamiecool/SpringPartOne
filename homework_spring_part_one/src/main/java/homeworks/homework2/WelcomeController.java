package homeworks.homework2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello World");
        return "index";
    }
}

