package com.bytecode.rental.model;

public class User {

    private int userId;
    private String name;
    private String email;
    private String password;
    private String mobile;

    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(String name, String email,
                String password, String mobile) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }

    // Getters and Setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}