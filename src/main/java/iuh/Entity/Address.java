/*
 * @(#)Address.java      1.0
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

public class Address {
//    city, district, street, ward
    private String city;
    private String district;
    private String street;
    private String ward;

    public Address() {
    }

    public Address(String city, String district, String street, String ward) {
        this.city = city;
        this.district = district;
        this.street = street;
        this.ward = ward;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public String getWard() {
        return ward;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", ward='" + ward + '\'' +
                '}';
    }
}
