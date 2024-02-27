/*
 * @(#)Tests.java      1.0
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

import java.time.LocalDate;

public class Tests {
    private LocalDate date;
    private String result;
    private int test_id;
    private String test_type;
    private double cost;

    public Tests() {
    }

    public Tests(LocalDate date, String result, int test_id, String test_type, double cost) {
        this.date = date;
        this.result = result;
        this.test_id = test_id;
        this.test_type = test_type;
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public String getTest_type() {
        return test_type;
    }

    public void setTest_type(String test_type) {
        this.test_type = test_type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Tests{" +
                "date=" + date +
                ", result='" + result + '\'' +
                ", test_id=" + test_id +
                ", test_type='" + test_type + '\'' +
                ", cost=" + cost +
                '}';
    }
}
