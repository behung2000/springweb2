package springweb.controller;

import springweb.dto.VegetableDto;

import springweb.services.VegetableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/v1/shop/vegetables")
public class VegetableController {
    private VegetableService service;

    public VegetableController(VegetableService service) {
        this.service = service;
    }
    
    @GetMapping("/index")
    public @ResponseBody List<VegetableDto> index(Model m)
    {
        return  service.findAll();
        //m.addAttribute("data", list);
        //return "home";
        
    }

    @GetMapping("/all")
    public String getAll(Model m)
    {
        List<VegetableDto> list = service.findAll();
        m.addAttribute("data", list);
        return "home";
        
    }
    
}
