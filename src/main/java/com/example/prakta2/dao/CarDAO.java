package com.example.prakta2.dao;

import com.example.prakta2.models.CarModel;
import com.example.prakta2.models.PersonModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {

    private static int CAR_COUNT;
    private List<CarModel> car;
    {
        car = new ArrayList<>();

        car.add(new CarModel(++CAR_COUNT,"BMW","M5",180000));
        car.add(new CarModel(++CAR_COUNT,"Dodge","Chellenger",150000));
        car.add(new CarModel(++CAR_COUNT,"Audi","A4",100000));
        car.add(new CarModel(++CAR_COUNT,"Nissan","340z",123000));
        car.add(new CarModel(++CAR_COUNT,"Kia","Rio",65000));

    }

    public List<CarModel> index(){

        return car;
    }

    public CarModel show(int id){
        return car.stream().filter(carModel -> carModel.getId() == id).findAny().orElse(null);
    }

    public void save(CarModel cars){
        cars.setId(++CAR_COUNT);
        car.add(cars);
    }

    public void update(int id, CarModel carModel){
        CarModel updateCar = show(id);
        updateCar.setMark(carModel.getMark());
        updateCar.setModel(carModel.getModel());
        updateCar.setCost(carModel.getCost());

    }


    public void delete(int id){
        car.removeIf(p-> p.getId() == id);
    }

}

