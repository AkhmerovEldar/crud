package ru.slorimer.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.slorimer.spring.DAO.userDAO;
import ru.slorimer.spring.model.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final userDAO userdAO;
    public AdminController(userDAO userdAO) {
        this.userdAO = userdAO;
    }
    @GetMapping()
    public String adminPage(Model model, @ModelAttribute("person") User user){
        model.addAttribute("people", userdAO.index());
        return "adminPage";
    }
    @PatchMapping("/add")
    public String makeAdmin(@ModelAttribute("person") User user){
        System.out.println(user.getId());
        return "redirect:/people";
    }
}
