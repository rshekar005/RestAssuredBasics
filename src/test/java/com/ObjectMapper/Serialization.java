package com.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Serialization {
    public static void main(String[] args) throws JsonProcessingException , IOException {
        Employee emp= new Employee();
        emp.setFirstname("Raja");
        emp.setLastname("Shekar");
        emp.setAge(23);
        emp.setMarried(false);
        List<String> food=Arrays.asList("Biryani","Dal");
        emp.setFavouriteFoods(food);

        Employee emp2= new Employee();
        emp2.setFirstname("Narayana");
        emp2.setLastname("Jonnala");
        emp2.setAge(28);
        emp2.setMarried(false);
        List<String> food2=Arrays.asList("Parata","Roti");
        emp2.setFavouriteFoods(food2);

        List<Employee> allEmployee=Arrays.asList(emp,emp2);
        ObjectMapper objectMapper= new ObjectMapper();
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allEmployee));
        File f = new File("src/test/resources/serialization.json");
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(f,allEmployee);
    }
}
