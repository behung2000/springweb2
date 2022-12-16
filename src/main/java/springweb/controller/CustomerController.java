package springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("v1/shop/customers")
public class CustomerController {
   /*
    @Autowired
    private CustomerRepository customersReposity;

    
    
    @GetMapping("/customer/add")
    public String register(Model m)
    {
        Customer cus = new Customer();
        m.addAttribute("customer", cus);
        return "customer_register";
        
    }
    @PostMapping("/customer/save")
    public String save(Model model, @ModelAttribute("customer") Customer customer)
    {
        
        customersReposity.save(customer);
        
        return "redirect:/customer/all";
        
    }
    @PostMapping("/customer/update")
    public String update(Model model, @ModelAttribute("customer") Customer customer)
    {
        Optional<Customer> cus = customersReposity.findById(customer.getCustomerID());
        Customer c;
        c = cus.get();
        c.setAddress(customer.getAddress());
        c.setCity(customer.getCity());
        c.setFullname(customer.getFullname());
        customersReposity.save(c);
        
        return "redirect:/customer/all";
        
    }
    @GetMapping("/customer/all")
    public String showAllCustomer(Model m)
    {
        Iterable<Customer> list = customersReposity.findAll();
        m.addAttribute("data", list);
        return "customer_all";
        
    }
    @GetMapping(value = {"customer/edit/{id}"})
    public String edit(@PathVariable("id") int id, Model model) {
        Optional<Customer> cus = customersReposity.findById(id);
        cus.ifPresent(customer->model.addAttribute("customer", cus));
        //model.addAttribute("customer", cus);
        return "customer_edit";
    }
     */
}
