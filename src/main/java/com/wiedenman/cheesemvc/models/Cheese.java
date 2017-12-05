package com.wiedenman.cheesemvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cheese {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=20, message = "Name must be between 3 and 20 characters.")
    private String name;

    @NotNull
    @Size(min=1, message = "Desciption required.")
    private String description;

    @NotNull(message = "Please select a cheese type.")
    private CheeseType type;

    @NotNull(message = "Please rate your cheese.")
    private CheeseRating rating;

    public Cheese(String name, String description, CheeseRating rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public Cheese() { }

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

    public void setRating(CheeseRating rating) {

        this.rating = rating;
    }

    public CheeseRating getRating() {

        return rating;
    }
}
