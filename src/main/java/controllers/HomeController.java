package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CRUDCustomer;


@Controller
public class HomeController {
    CRUDCustomer crudCustomer = new CRUDCustomer();

    @RequestMapping("/show")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", crudCustomer.list);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }


}
