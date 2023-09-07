package com.example.prakta2.models;

public class AnimeModel {
    private int id;

    private String name;

    public AnimeModel(int id, String name, String author, int rating) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.rating = rating;
    }

    private String author;

    private int rating;


    public AnimeModel() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

