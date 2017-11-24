package com.wiedenman.cheesemvc.models;

import java.util.HashMap;

public class CheeseData {

    static HashMap<Integer, Cheese> cheeses = new HashMap<>();

    //getAll
    public static HashMap<Integer, Cheese> getAll() {

        return cheeses;
    }

    // put
    public static void put(Integer cheeseId, Cheese newCheese) {

        cheeses.put(newCheese.getId(), newCheese);
    }

    // remove
    public static void removeCheese(int id) {

        cheeses.remove(id);
    }

    // getById
    public static Cheese getById(int id) {

        return cheeses.get(id);
    }


}
