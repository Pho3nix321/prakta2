package com.example.prakta2.models;

public class CarModel {
    private int _id;
    private String _mark;
    private String _model;
    private int _cost;

    public CarModel(){
        
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getMark() {
        return _mark;
    }

    public void setMark(String _mark) {
        this._mark = _mark;
    }

    public String getModel() {
        return _model;
    }

    public void setModel(String _model) {
        this._model = _model;
    }

    public int getCost() {
        return _cost;
    }

    public void setCost(int _cost) {
        this._cost = _cost;
    }

    public CarModel(int _id, String _mark, String _model, int _cost) {
        this._id = _id;
        this._mark = _mark;
        this._model = _model;
        this._cost = _cost;
    }
}
