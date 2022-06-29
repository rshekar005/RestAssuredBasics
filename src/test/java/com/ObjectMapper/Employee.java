package com.ObjectMapper;

import java.util.List;

public class Employee {
    private String firstname;
    private String lastname;
    private int age;
    private boolean isMarried;
    private List<String> favouriteFoods;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public List<String> getFavouriteFoods() {
        return favouriteFoods;
    }

    public void setFavouriteFoods(List<String> favouriteFoods) {
        this.favouriteFoods = favouriteFoods;
    }
}
