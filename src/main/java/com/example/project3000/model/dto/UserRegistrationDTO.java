package com.example.project3000.model.dto;


import javax.validation.constraints.*;

public class UserRegistrationDTO {

    @NotBlank
    private String username;

    @NotNull
    private String fullName;

    @NotNull
    @Email
    private String email;

    @Min(18)
    private int age;

    @NotNull
    @Size(min = 6,max = 20)
    private String password;

    @NotNull
    @Size(min = 6,max = 20)
    private String confirmPassword;

    public UserRegistrationDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
