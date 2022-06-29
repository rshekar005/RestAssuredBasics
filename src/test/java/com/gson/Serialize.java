package com.gson;

import com.ObjectMapper.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

public class Serialize {
    public static void main(String[] args) {
        Employee employee= new Employee();
        employee.setFirstname("Rajashekar");
        employee.setLastname("Pillalamarri");
        employee.setAge(20);
        employee.isMarried();
        List<String> foods= Arrays.asList("Dosa","Puri");
        employee.setFavouriteFoods(foods);

        Gson gson= new Gson();
        String employeeJSON=gson.toJson(employee);
        System.out.println(employeeJSON);

        Gson gsonBuilder= new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gsonBuilder.toJson(employee));




    }
}
