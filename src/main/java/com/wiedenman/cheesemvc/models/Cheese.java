package com.wiedenman.cheesemvc.models;

public class Cheese {

    private static int nextCheeseId = 1;
    public static String cheeseName;
    private final int cheeseId;
    public static String cheeseDescription;

    public Cheese(String cheeseName, int cheeseId,
                  String cheeseDescription) {

        this.cheeseName = cheeseName;
        this.cheeseId = cheeseId;
        this.cheeseDescription = cheeseDescription;
    }

    public Cheese(String cheeseName, String cheeseDescription) {

        this(cheeseName, nextCheeseId++, cheeseDescription);
    }

    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String aCheeseName) {
        cheeseName = aCheeseName;
    }

    public Integer getCheeseId() {
        return cheeseId;
    }

//    private void setCheesId(Integer aCheeseId) {  // TODO: Figure out what to do with setId
//        cheeseId = aCheeseId;
//    }


    public String getCheeseDescription() {
        return cheeseDescription;
    }

    public void setCheeseDescription(String cheeseDescription) {
        cheeseDescription = cheeseDescription;  // TODO: Does this need to be preceeded by this.?
    }
}
