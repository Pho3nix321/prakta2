package com.example.prakta2.models;

public class LaptopModel {
    private int _id;
    private String  _brand;
    private String _model;
    private int _cost;
    public LaptopModel(){}

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getBrand() {
        return _brand;
    }

    public void setBrand(String brand) {
        this._brand = brand;
    }

    public String getModel() {
        return _model;
    }

    public void setModel(String model) {
        this._model = model;
    }

    public int getCost() {
        return _cost;
    }

    public void setCost(int cost) {
        this._cost = cost;
    }

    public LaptopModel(int id, String brand, String model, int cost) {
        this._id = id;
        this._brand = brand;
        this._model = model;
        this._cost = cost;
    }
}
