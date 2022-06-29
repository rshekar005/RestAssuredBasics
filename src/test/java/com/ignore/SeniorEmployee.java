/**
 *
 */
package com.ignore;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author rajasekhar
 * If we use annotation to do not include Not_Null then it will avoid fields which is having null values(String) at run time.
 * But it cannot achive if payload contains String[], List<String> , map<String,String> , here it will add empty array to payload
 * To avoid above issue we need to add INCLUDE.NON_EMPTY
 *
 * NON_EMPTY + NON_NULL + NON_ABSENT
 *
 * @Json
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class SeniorEmployee {
    // private variables or data members of pojo class
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private double salary;
    private boolean married;
    private String[] mobileNo;
    private List<String> cars;
    private Map<String, String> familyMembers;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String[] getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String[] mobileNo) {
        this.mobileNo = mobileNo;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public Map<String, String> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Map<String, String> familyMembers) {
        this.familyMembers = familyMembers;
    }


}
