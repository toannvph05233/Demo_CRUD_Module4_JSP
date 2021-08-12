package controllers;

import models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.CRUDCustomer;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    CRUDCustomer crudCustomer = new CRUDCustomer();

    @RequestMapping("/show")
    public String home(HttpServletRequest request) {
        request.setAttribute("list", crudCustomer.list);
        return "/WEB-INF/show.jsp";
    }

    @GetMapping("/edit")
    public String showedit(HttpServletRequest request, @RequestParam int index) {
        request.setAttribute("customer", crudCustomer.list.get(index));
        return "/WEB-INF/edit.jsp";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "/WEB-INF/create.jsp";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int index) {
        crudCustomer.delete(index);
        return "redirect:/show";
    }


    @PostMapping("/edit")
    public String edit(@RequestParam int index,@ModelAttribute Customer customer) {
        crudCustomer.edit(customer, index);
        return "redirect:/show";
    }

    @PostMapping("/create")
    public String creaate(@ModelAttribute Customer customer) {
        crudCustomer.save(customer);
        return "redirect:/show";
    }
}
