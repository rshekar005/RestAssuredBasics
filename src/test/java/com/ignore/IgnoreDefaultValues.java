/**
 * 
 */
package com.ignore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
/** It won't add a field which is having default value in request payload
 * 	Example: I will not pass gender/age in request payload.
 *           If below annotation is not added then it Java will add default values to Gender(String: null) and age(Integer: 0) to payload.
 *           
 *           To avoid above issue below annotation is used.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true) // This property is used when there is extra objects are retrieved from response apart from POJO.
public class IgnoreDefaultValues {
	private String firstname;
	private String lastname;
	private String gender;
	private int age;
	private double salary;
	private boolean married;
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
	
}
