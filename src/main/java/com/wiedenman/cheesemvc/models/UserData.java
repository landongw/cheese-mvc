package com.wiedenman.cheesemvc.models;

import java.util.HashMap;

public class UserData {

    static HashMap<Integer, User> users = new HashMap<>();

    public static void put(int userId, User newUser) {

        users.put(newUser.getId(), newUser);
    }

    public static HashMap<Integer, User> getAll() {
        return users;
    }

    public static User getById(int userId) {
        return users.get(userId);
    }
}
