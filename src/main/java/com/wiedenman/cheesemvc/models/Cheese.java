package com.wiedenman.cheesemvc.models;

public class Cheese {

    private int id;
    private static int nextCheeseId = 1;
    private String name;
    private String description;

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
    //    public String getCheeseName() {
//        return name;
//    }
//
//    public void setCheeseName(String aCheeseName) {
//        name = aCheeseName;
//    }
//
//    public Integer getCheeseId() {
//        return id;
//    }
//
//    private void setCheesId(Integer aCheeseId) {  // TODO: Figure out what to do with setId
//        id = aCheeseId;
//    }
//
//
//    public String getCheeseDescription() {
//        return description;
//    }
//
//    public void setCheeseDescription(String adescription) {
//        description = adescription;
//    }
}
