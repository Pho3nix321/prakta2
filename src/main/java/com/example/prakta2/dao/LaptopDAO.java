package com.example.prakta2.dao;

import com.example.prakta2.models.LaptopModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LaptopDAO {

    private static int LAPTOP_COUNT;
    private List<LaptopModel> laptop;
    {
        laptop = new ArrayList<>();

        laptop.add(new LaptopModel(++LAPTOP_COUNT,"Asus","Susa",45000));
        laptop.add(new LaptopModel(++LAPTOP_COUNT,"Acer","Aspire 5",54000));


    }

    public List<LaptopModel> index(){

        return laptop;
    }

    public LaptopModel show(int id){
        return laptop.stream().filter(laptopModel -> laptopModel.getId() == id).findAny().orElse(null);
    }

    public void save(LaptopModel laptops){
        laptops.setId(++LAPTOP_COUNT);
        laptop.add(laptops);
    }

    public void update(int id, LaptopModel laptopModel){
        LaptopModel updatelaptop = show(id);
        updatelaptop.setBrand(laptopModel.getBrand());
        updatelaptop.setModel(laptopModel.getModel());
        updatelaptop.setCost(laptopModel.getCost());

    }


    public void delete(int id){
        laptop.removeIf(p-> p.getId() == id);
    }

}
