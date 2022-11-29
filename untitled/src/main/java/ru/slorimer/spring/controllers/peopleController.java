package ru.slorimer.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.slorimer.spring.DAO.userDAO;
import ru.slorimer.spring.model.User;

@Controller
@RequestMapping("/people")
public class peopleController {
    private userDAO userdAO;


    public peopleController(userDAO userdAO) {
        this.userdAO = userdAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", userdAO.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", userdAO.show(id));
        return "people/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new User());
        return "people/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") User user){
        userdAO.save(user);
        return "redirect:/people";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", userdAO.show(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") User user, @PathVariable("id") int id){
        userdAO.edit(id, user);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userdAO.delete(id);
        return "redirect:/people";
    }
}
