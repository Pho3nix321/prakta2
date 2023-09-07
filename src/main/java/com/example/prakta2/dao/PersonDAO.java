package com.example.prakta2.dao;

import com.example.prakta2.models.PersonModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<PersonModel> people;
    {
        people = new ArrayList<>();

        people.add(new PersonModel(++PEOPLE_COUNT,"Константин","Некрасов",18));
        people.add(new PersonModel(++PEOPLE_COUNT,"Глеб","Бобров",19));
        people.add(new PersonModel(++PEOPLE_COUNT,"Евгений","Бобряшов",24));
        people.add(new PersonModel(++PEOPLE_COUNT,"Дмитирий","Данильченко",66));
        people.add(new PersonModel(++PEOPLE_COUNT,"Екатерина","Соломатина",19));

    }

    public List<PersonModel> index(){

        return people;
    }

    public PersonModel show(int id){
        return people.stream().filter(personModel -> personModel.getId() == id).findAny().orElse(null);
    }

    public void save(PersonModel person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, PersonModel personModel){
        PersonModel updatePerson = show(id);
        updatePerson.setName(personModel.getName());
        updatePerson.setSurname(personModel.getSurname());
        updatePerson.setAge(personModel.getAge());

    }


    public void delete(int id){
        people.removeIf(p-> p.getId() == id);
    }

}
