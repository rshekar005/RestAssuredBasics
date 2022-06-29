package com.gson;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class Deserialize {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setFirstname("Rajashekar");
        employee.setLastname("Pillalamarri");
        employee.setAge(20);
        employee.isMarried();
        List<String> foods = Arrays.asList("Dosa", "Puri");
        employee.setFavouriteFoods(foods);

        Gson gson = new Gson();
        String employeeJSON = gson.toJson(employee);
        Employee employee1 = gson.fromJson(employeeJSON, Employee.class);
        System.out.println(employee1.getFirstname());

    }
}
