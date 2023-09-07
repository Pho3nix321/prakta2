package com.example.prakta2.controller;


import com.example.prakta2.dao.CarDAO;
import com.example.prakta2.models.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/car")
public class  CarController {

    private final CarDAO _carDAO;

    @Autowired
    public CarController(CarDAO carDAO){
        _carDAO = carDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("car", _carDAO.index());
        return "car/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("cars", _carDAO.show(id));
        return "car/show";
    }


    @GetMapping("/new")
    public String newCar(@ModelAttribute("cars") CarModel carModel){
        // model.addAttribute("person", new PersonModel());
        return "car/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("cars") CarModel carModel){
        _carDAO.save(carModel);
        return "redirect:/car";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("cars",_carDAO.show(id));
        return "car/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("cars") CarModel carModel, @PathVariable("id") int id){
        _carDAO.update(id,carModel);
        return "redirect:/car";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _carDAO.delete(id);
        return "redirect:/car";
    }

}

