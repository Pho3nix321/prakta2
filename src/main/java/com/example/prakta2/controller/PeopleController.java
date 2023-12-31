package com.example.prakta2.controller;

import com.example.prakta2.dao.PersonDAO;
import com.example.prakta2.models.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class  PeopleController {

    private PersonDAO _personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO){
        _personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", _personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        // Вывод определенного пользователя
        model.addAttribute("person", _personDAO.show(id));
        return "people/show";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") PersonModel personModel){
        // model.addAttribute("person", new PersonModel());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") PersonModel personModel){
        _personDAO.save(personModel);
        return "redirect:/people";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person",_personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") PersonModel personModel, @PathVariable("id") int id){
        _personDAO.update(id,personModel);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _personDAO.delete(id);
        return "redirect:/people";
    }


}

