package com.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.handlingresponse.Address;
import io.restassured.common.mapper.TypeRef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deserialization {
    public static void main(String[] args) throws JsonProcessingException {
        Employee rajashekar = new Employee();
        rajashekar.setFirstname("Raja");
        rajashekar.setLastname("Shekar");
        rajashekar.setAge(23);
        rajashekar.setMarried(false);
        List<String> food = Arrays.asList("Biryani", "Dal");
        rajashekar.setFavouriteFoods(food);

        Employee narayana = new Employee();
        narayana.setFirstname("Raja");
        narayana.setLastname("Shekar");
        narayana.setAge(23);
        narayana.setMarried(false);
        List<String> food2 = Arrays.asList("Biryani", "Dal");
        narayana.setFavouriteFoods(food2);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.addAll(Arrays.asList(rajashekar,narayana));

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeList);

        // 1st way recommended
        List<Employee> allEmployee = objectMapper.readValue(jsonString, new TypeReference<List<Employee>>() {
        });

        System.out.println("Size of an array is "+allEmployee.size());
        System.out.println("FirstName is "+allEmployee.get(0).getFirstname());
        // 2nd way
        Employee[] employees = objectMapper.readValue(jsonString, Employee[].class);
    }
}
