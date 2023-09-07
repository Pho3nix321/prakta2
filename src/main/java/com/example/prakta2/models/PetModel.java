package com.example.prakta2.models;

public class PetModel {
    private int _id;

    private String _type;

    private String _breed;

    private int _age;

    public PetModel() {

    }

    public PetModel(int _id, String _type, String _breed, int _age) {
        this._id = _id;
        this._type = _type;
        this._breed = _breed;
        this._age = _age;
    }

    public int getAge() {
        return _age;
    }

    public void setAge(int _age) {
        this._age = _age;
    }

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    public String getBreed() {
        return _breed;
    }

    public void setBreed(String _breed) {
        this._breed = _breed;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }
}
