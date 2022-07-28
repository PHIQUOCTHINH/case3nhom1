package com.example.demo12.model;

import java.time.LocalDate;
import java.util.Date;

public class User {
    private int id;
    private String name_user;
    private String email;
    private String password_user;
    private String birth;
    private String phoneNumber;
    private String image;

    public User() {
    }

    public User(String email, String password_user) {
        this.email = email;
        this.password_user = password_user;
    }

    public User(String name_user, String email, String password_user, String birth, String phoneNumber, String image) {
        this.name_user = name_user;
        this.email = email;
        this.password_user = password_user;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.image = image;
    }

    public User(int id, String name_user, String email, String password_user, String birth, String phoneNumber, String image) {
        this.id = id;
        this.name_user = name_user;
        this.email = email;
        this.password_user = password_user;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name_user='" + name_user + '\'' +
                ", email='" + email + '\'' +
                ", password_user='" + password_user + '\'' +
                ", birth=" + birth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
