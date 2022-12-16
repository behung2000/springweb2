
package springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("v1/shop/categories")
public class CategoryController {
    /*
    
    @Autowired CategoryRepository categoryRepository; //
    
    @GetMapping( value = "/category")
    public String getAll(Model model)
    {
        Iterable<Category> list = categoryRepository.findAll();
        model.addAttribute("list", list);
        return "category";
        
        
    }
     */
}
