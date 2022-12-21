package springweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springweb.requests.Login;
import springweb.services.CustomerService;

@Slf4j
@Controller
@RequestMapping("v1/shop")
public class LoginController {
    private static Integer customerId = null;
    private CustomerService service;

    public LoginController(CustomerService service) {
        this.service = service;
    }

    public static Integer getLogin() {
        return customerId;
    }

    @GetMapping("/login")
    public String methodGetLogin() {
        if (customerId != null) {
            return String.format("redirect:/v1/shop/customers/%s", customerId);
        }
        return "Login";
    }

    @GetMapping("/login/action")
    public String methodPostLogin(Model model, Login login) {
        model.addAttribute("fullName", login.getFullName());
        model.addAttribute("password", login.getPassword());
        log.info(login.toString());
        Integer id = service.checkLogin(login);
        if (id != null) {
            customerId = id;
            return "redirect:/v1/shop/vegetables";
        }
        return "LoginFail";
    }

    @GetMapping("")
    public String shop() {
        return "redirect:/v1/shop/vegetables/";
    }

    @GetMapping("/logout")
    public String logout() {
        customerId = null;
        return "redirect:/v1/shop";
    }
}
