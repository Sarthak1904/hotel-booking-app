package com.example.Domain;

public class User {


    String name,email,number;
    String dpUrl;

    public User() {
    }


    public User(String name, String email, String number, String dpUrl) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.dpUrl=dpUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public User(String url){
        this.dpUrl=url;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }
}





