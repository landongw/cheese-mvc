package com.wiedenman.cheesemvc.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class User {
    private static int nextId = 0;
    private final int id;

    @NotNull
    @Size(min=5, max=20, message="Username must be between 5 and 20 characters long. ")
    private String username;

    @Size(min=1, message="Valid email required. ")
    @Email
    private String email;

    @NotNull
    @Size(min=6, message="Password must be at least 6 characters long. ")
    private String password;

    @NotNull(message="Passwords do not match. ")
    @Size(min=6, message="Passwords do not match. ")
    private String verifyPassword;

    private final LocalDate creationDate;

    public static LocalDate date = LocalDate.now();

    public User(String username, String email, String password, String verifyPassword) {
        this.id = nextId++;
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
        this.creationDate = date;
    }

    public User() {
        this.creationDate = date;
        this.id = nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        User.nextId = nextId++;
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
        checkPassword();
    }

    public int getId() {
        return id;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();

    }

    private void checkPassword() {
    /**If password and verifyPassword are not null and they do not match, reset verifyPassword to null.*/

        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }

    public LocalDate getCreationDate() {

        return creationDate;
    }
}
