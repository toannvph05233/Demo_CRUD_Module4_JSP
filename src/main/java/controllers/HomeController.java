package controllers;

import models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String showedit(HttpServletRequest request) {
        int index = Integer.parseInt(request.getParameter("index"));
        request.setAttribute("customer", crudCustomer.list.get(index));
        return "/WEB-INF/edit.jsp";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "/WEB-INF/create.jsp";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        int index = Integer.parseInt(request.getParameter("index"));
        crudCustomer.delete(index);

        request.setAttribute("list", crudCustomer.list);
        return "/WEB-INF/show.jsp";
    }


    @PostMapping("/edit")
    public String edit(HttpServletRequest request) {
        int index = Integer.parseInt(request.getParameter("index"));
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Customer customer = new Customer(id, name, email);
        crudCustomer.edit(customer, index);

        request.setAttribute("list", crudCustomer.list);
        return "/WEB-INF/show.jsp";
    }

    @PostMapping("/create")
    public String creaate(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Customer customer = new Customer(id, name, email);
        crudCustomer.save(customer);

        request.setAttribute("list", crudCustomer.list);
        return "/WEB-INF/show.jsp";
    }
}
