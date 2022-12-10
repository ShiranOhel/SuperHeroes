package com.example.superheroes;

public class SuperHeroModel {
    private String name;
    private String details;
    private int image;

    public SuperHeroModel(String name, String details, int image) {
        this.name = name;
        this.details = details;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public int getImage() {
        return image;
    }
}
