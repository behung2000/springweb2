package springweb.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import springweb.dto.VegetableDto;

import springweb.requests.Search;
import springweb.services.VegetableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1/shop/vegetables")
public class VegetableController {
    private VegetableService service;

    public VegetableController(VegetableService service) {
        this.service = service;
    }

    @GetMapping("")
    public String getAll(Model m, Search search) {
        search.initInput();
        m.addAttribute("name", search.getName());
        m.addAttribute("categoryId", search.getCategoryId());
        m.addAttribute("banChay", search.getBanChay());
        List<VegetableDto> list = service.search(search);
        m.addAttribute("data", list);
        return "homeshop";
    }
    
}
