package com.example.prakta2.dao;

import com.example.prakta2.models.PetModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetDAO {

    private static int PET_COUNT;
    private List<PetModel> pet;
    {
        pet = new ArrayList<>();

        pet.add(new PetModel(++PET_COUNT,"Птица","Попугай",2));
        pet.add(new PetModel(++PET_COUNT,"Собака","Бултерьер",1));
        pet.add(new PetModel(++PET_COUNT,"Кошка","Британская",5));


    }

    public List<PetModel> index(){

        return pet;
    }

    public PetModel show(int id){
        return pet.stream().filter(petModel -> petModel.getId() == id).findAny().orElse(null);
    }

    public void save(PetModel pets){
        pets.setId(++PET_COUNT);
        pet.add(pets);
    }

    public void update(int id, PetModel petModel){
        PetModel updatePet = show(id);
        updatePet.setAge(petModel.getAge());
        updatePet.setType(petModel.getType());
        updatePet.setBreed(petModel.getBreed());

    }


    public void delete(int id){
        pet.removeIf(p-> p.getId() == id);
    }

}
