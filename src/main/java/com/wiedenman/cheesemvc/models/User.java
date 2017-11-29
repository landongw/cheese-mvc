package com.wiedenman.cheesemvc.models;

public class User {
    private static int nextId = 1;
    private final int id;
    private String username;
    private String email;
    private String password;

    public User(int id, String username, String email, String password) {
        this.id = nextId++;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
        this.id = nextId++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
