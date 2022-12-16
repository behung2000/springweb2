package springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springweb.dto.Login;
import springweb.service.CustomerService;

@Controller
@RequestMapping("v1/shop")
public class LoginController {
    private static boolean login = false;
    private CustomerService service;

    public LoginController(CustomerService service) {
        this.service = service;
    }

    public static boolean getLogin() {
        return login;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexHomeShopLogin(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "index";
    }

    @GetMapping("/login")
    public String methodGetLogin() {
        return "login";
    }

    @GetMapping("/login/action")
    public String methodPostLogin(Login login) {
        return "Susscess";
    }
}
