/*
 * @(#)ObjectModelHandler.java      1.0
 *
 * Copyright (c)  IUH
 * All rights reserved.
 */

package iuh.Handler;/*
 * @description
 * @author:  Phạm Đăng Khôi
 * @date :
 * @version : 1.0
 */

import iuh.Entity.Address;
import iuh.Entity.Patient;
import iuh.Entity.Tests;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ObjectModelHandler {
    public Patient fromFile(String path, String keyName) throws FileNotFoundException {
        Patient patient = new Patient();
        Address address = new Address();
        List<String> telephones = new ArrayList<>();
        List<Tests> tests = new ArrayList<>();
        try(JsonReader  jR = Json.createReader(new FileReader(path))) {
            JsonArray ja = jR.readArray();
            for (JsonValue jv : ja) {
                JsonObject jO = (JsonObject) jv;
                if (jO != null) {
                    String _id = jO.getString("_id");
                    if(_id.equals(keyName)) {
                        patient.set_id(jO.getString("_id"));
                        patient.setFirstName(jO.getString("first_name"));
                        patient.setLastName(jO.getString("last_name"));
                        patient.setBloodType(jO.getString("blood_type"));
                        patient.setGender(jO.getString("gender"));
                        patient.setYearOfBirth(jO.getInt("year_of_birth"));
                        JsonObject jOAdd = jO.getJsonObject("address");
                        address = new Address();
                        address.setCity(jOAdd.getString("city"));
                        address.setDistrict(jOAdd.getString("district"));
                        address.setStreet(jOAdd.getString("street"));
                        address.setWard(jOAdd.getString("ward"));
                        patient.setAddress(address);
                        JsonArray jATests = jO.getJsonArray("tests");
                        for (JsonValue jvTest : jATests) {
                            JsonObject jOTest = (JsonObject) jvTest;
                            Tests test = new Tests();
                            JsonObject jODate = jOTest.getJsonObject("date");
                            test.setDate(LocalDate.of(jODate.getInt("year"), jODate.getInt("month"), jODate.getInt("day")));
                            test.setResult(jOTest.getString("result"));
                            test.setTest_id(jOTest.getInt("test_id"));
                            test.setTest_type(jOTest.getString("test_type"));
                            test.setCost(jOTest.getInt("cost"));
                            tests.add(test);
                        }
                        patient.setTests((ArrayList<Tests>) tests);
                        JsonArray jATelephones = jO.asJsonObject().getJsonArray("telephones");
                        for (JsonValue jvTel : jATelephones) {
                            telephones.add(jvTel.toString());
                        }
                        patient.setTelephones((ArrayList<String>) telephones);
                    }
                }
            }
        }
        return patient;
    }
}
