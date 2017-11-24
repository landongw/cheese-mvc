package com.wiedenman.cheesemvc.models;

import javax.swing.plaf.FontUIResource;

public enum CheeseRating {
    ONE ("1 Star"),
    TWO ("2 Stars"),
    THREE ("3 Stars"),
    FOUR ("4 Stars"),
    FIVE ("5 Stars");

    private final String stars;

    CheeseRating(String stars) {
        this.stars = stars;
    }

    public String getStars() {
        return stars;
    }
}

