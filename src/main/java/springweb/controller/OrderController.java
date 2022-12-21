package springweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springweb.dto.CategoryDto;
import springweb.dto.CustomerDto;
import springweb.dto.VegetableDto;
import springweb.repository.CategoryRepository;
import springweb.requests.CreateOrder;
import springweb.requests.Search;
import springweb.services.CategoryService;
import springweb.services.OrderedService;
import springweb.services.VegetableService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("v1/shop/orders")
public class OrderController {
    private OrderedService service;
    private VegetableService vegetableService;
    private CategoryService categoryService;

    public OrderController(OrderedService service, VegetableService vegetableService, CategoryService categoryService) {
        this.service = service;
        this.vegetableService = vegetableService;
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String orderHome(Model model, @ModelAttribute("createOrder") CreateOrder createOrder, Search search) {
        if (LoginController.getLogin() == null) {
            return "LoginToOrder";
        }
        List<CategoryDto> categoryDtoList = categoryService.getAll();
        categoryDtoList.add(CategoryDto.builder().id(null).name("All").build());
        model.addAttribute("categories", categoryDtoList);
        log.info(search.toString());
        search.initInput();
        model.addAttribute("name", search.getName());
        model.addAttribute("categoryId", search.getCategoryId());
        model.addAttribute("banChay", search.getBanChay());
        List<VegetableDto> list = vegetableService.search(search);
        model.addAttribute("data", list);
        return "Order";
    }

    @PostMapping("")
    public String order(Model model, CreateOrder createOrder) {
        return "123";
    }
}
