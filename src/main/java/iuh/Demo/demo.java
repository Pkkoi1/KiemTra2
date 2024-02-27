/*
 * @(#)demo.java      1.0
 *
 * Copyright (c)  IUH
 * All rights reserved.
 */

package iuh.Demo;/*
 * @description
 * @author:  Phạm Đăng Khôi
 * @date :
 * @version : 1.0
 */

import iuh.Entity.Patient;
import iuh.Handler.ObjectModelHandler;

import java.util.List;

public class demo {
    public static void main(String[] args) {
        ObjectModelHandler objectModelHandler = new ObjectModelHandler();
        try {
            Patient patients = objectModelHandler.fromFile("data\\Patient.json", "PT_4975");
            System.out.println(patients);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
