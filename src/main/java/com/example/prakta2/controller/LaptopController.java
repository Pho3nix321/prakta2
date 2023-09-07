package com.example.prakta2.controller;

import com.example.prakta2.dao.LaptopDAO;
import com.example.prakta2.models.LaptopModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/laptop")
public class  LaptopController {

    private final LaptopDAO _laptopDAO;

    @Autowired
    public LaptopController(LaptopDAO laptopDAO){
        _laptopDAO = laptopDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("laptop", _laptopDAO.index());
        return "laptop/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        // Вывод определенного пользователя
        model.addAttribute("laptops", _laptopDAO.show(id));
        return "laptop/show";
    }


    @GetMapping("/new")
    public String newLaptop(@ModelAttribute("laptops") LaptopModel laptopModel){
        return "laptop/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("laptops") LaptopModel laptopModel){
        _laptopDAO.save(laptopModel);
        return "redirect:/laptop";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("laptops",_laptopDAO.show(id));
        return "laptop/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("laptops") LaptopModel laptopModel, @PathVariable("id") int id){
        _laptopDAO.update(id,laptopModel);
        return "redirect:/laptop";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _laptopDAO.delete(id);
        return "redirect:/laptop";
    }


}

