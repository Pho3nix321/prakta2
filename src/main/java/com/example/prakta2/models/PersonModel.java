package com.example.prakta2.models;

public class PersonModel {
    private int _id;

    private String _name;

    private String _surname;

    private int _age;

    public PersonModel() {

    }

    public PersonModel(int _id, String _name, String _surname, int _age) {
        this._id = _id;
        this._name = _name;
        this._surname = _surname;
        this._age = _age;
    }

    public int getAge() {
        return _age;
    }

    public void setAge(int _age) {
        this._age = _age;
    }

    public String getSurname() {
        return _surname;
    }

    public void setSurname(String _surname) {
        this._surname = _surname;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }
}
