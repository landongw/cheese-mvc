package com.wiedenman.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {

    private int id;
    private static int nextCheeseId = 1;

    @NotNull
    @Size(min=3, max=20, message = "Name must be between 3 and 20 characters.")
    private String name;

    @NotNull
    @Size(min=1, message = "Desciption required.")
    private String description;

    private CheeseType type;

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Cheese() {
        id = nextCheeseId++;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}
