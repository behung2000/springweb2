package springweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
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
        return "login";
    }

    @GetMapping("/login/action")
    public String methodPostLogin(Model model, @Param("fullName") String fullName, @Param("password") String password) {
        model.addAttribute("fullName", fullName);
        model.addAttribute("password", password);
        Login login = Login.builder().fullName(fullName).password(password).build();
        log.info(login.toString());
        Integer id = service.checkLogin(login);
        if (id != null) {
            customerId = id;
            return "redirect:/v1/shop/vegetables";
        }
        return "loginfail";
    }
}
