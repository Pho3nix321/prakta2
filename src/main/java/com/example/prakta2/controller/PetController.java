package com.example.prakta2.controller;

import com.example.prakta2.dao.PetDAO;
import com.example.prakta2.models.PetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pet")
public class  PetController {

    private final PetDAO _petDAO;

    @Autowired
    public PetController(PetDAO petDAO){
        _petDAO = petDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("pet", _petDAO.index());
        return "pet/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        // Вывод определенного пользователя
        model.addAttribute("pets", _petDAO.show(id));
        return "pet/show";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("pets") PetModel petModel){
        // model.addAttribute("person", new PersonModel());
        return "pet/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("pets") PetModel petModel){
        _petDAO.save(petModel);
        return "redirect:/people";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("pets",_petDAO.show(id));
        return "pet/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("pets") PetModel petModel, @PathVariable("id") int id){
        _petDAO.update(id,petModel);
        return "redirect:/pet";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _petDAO.delete(id);
        return "redirect:/pet";
    }


}

