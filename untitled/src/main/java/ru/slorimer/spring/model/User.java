package ru.slorimer.spring.model;

import javax.validation.constraints.*;

public class User {
    @Size(min = 2, max = 13, message = "incorrect name")
    private String name;
    private int id;
    @NotEmpty(message = "field is empty")
    @Email(message = "wrong email")
    private String email;
    @Min(value = 0, message = "incorrect age")
    @Max(value = 99, message = "incorrect age")
    private int age;
    public User(int id, String name, int age, String email) {
        this.age = age;
        this.email = email;
        this.name = name;
        this.id = id;
    }
    public User(){}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
