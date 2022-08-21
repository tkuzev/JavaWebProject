package com.example.project3000.model.views;

import com.example.project3000.model.enums.Level;

public class UsersProfileView {
    private String fullName;

    private String username;

    private int age;

    private Level level;

    public UsersProfileView() {
    }

    public UsersProfileView(String username, String fullName, int age, Level level) {
        this.fullName = fullName;
        this.username = username;
        this.age = age;
        this.level = level;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
