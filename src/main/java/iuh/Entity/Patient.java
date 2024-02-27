/*
 * @(#)Patient.java      1.0
 *
 * Copyright (c)  IUH
 * All rights reserved.
 */

package iuh.Entity;/*
 * @description
 * @author:  Phạm Đăng Khôi
 * @date :
 * @version : 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class Patient {
//    _id, firstName, lastName, bloodType, gender, yearOfBirth, address, tests, telephones
    private String  _id;
    private String firstName;
    private String lastName;
    private String bloodType;
    private String gender;
    private int yearOfBirth;
    private Address address;
    private List<Tests> tests;
    private ArrayList<String> telephones;

    public Patient() {
    }

    public Patient(String _id, String firstName, String lastName, String bloodType, String gender, int yearOfBirth, Address address, ArrayList<Tests> tests, ArrayList<String> telephones) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bloodType = bloodType;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.tests = tests;
        this.telephones = telephones;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

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

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Tests> getTests() {
        return tests;
    }

    public void setTests(ArrayList<Tests> tests) {
        this.tests = tests;
    }

    public ArrayList<String> getTelephones() {
        return telephones;
    }

    public void setTelephones(ArrayList<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "_id=" + _id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", gender='" + gender + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", address=" + address +
                ", tests=" + tests +
                ", telephones=" + telephones +
                '}';
    }
}
