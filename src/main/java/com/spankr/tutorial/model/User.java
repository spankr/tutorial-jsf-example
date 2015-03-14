package com.spankr.tutorial.model;

import java.util.Date;

public class User {

    private String firstName;
    private String lastName;
    private String dob;
    private String sex;
    private String email;
    private String answer;

    public User(String firstName, String lastName, String dob, String sex, String email, String answer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.sex = sex;
        this.email = email;
        this.answer = answer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public String getAnswer() {
        return answer;
    }
}
