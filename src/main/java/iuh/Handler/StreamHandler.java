/*
 * @(#)StreamHandler.java      1.0
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

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StreamHandler {
    public static void main(String[] args) throws IOException {
        StreamHandler streamHandler = new StreamHandler();
        try {
            List<Patient> patient = streamHandler.readPatients("data\\Patient.json", "PT_49759");
          for (Patient p : patient) {
              System.out.println(p);
          }
            streamHandler.exportPatient(patient, "data\\Patient1.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Patient readPatient(String line) throws FileNotFoundException {
        Patient patient = null;
        String keyName = "";
        List<Tests> tests = null;
        List<String> telephones = null;
        Address address = null;
        LocalDate date = null;

        try (JsonParser jP = Json.createParser(new FileReader(line))) {
            while (jP.hasNext()) {
                JsonParser.Event event = jP.next();
                switch (event) {
                    case START_OBJECT:
                        if (keyName.equals("address")) {
                            address = new Address();
                        } else {
                            patient = new Patient();
                        }
                        break;
                    case KEY_NAME:
                        keyName = jP.getString();
                        break;
                    case VALUE_STRING:
                        if ("first_name".equals(keyName)) {
                            patient.setFirstName(jP.getString());
                        } else if ("last_name".equals(keyName)) {
                            patient.setLastName(jP.getString());
                        } else if ("blood_type".equals(keyName)) {
                            patient.setBloodType(jP.getString());
                        }
                        else if(keyName.equals("gender"))
                            patient.setGender(jP.getString());
                        else if(keyName.equals("city"))
                            address.setCity(jP.getString());
                        else if(keyName.equals("district"))
                            address.setDistrict(jP.getString());
                        else if(keyName.equals("street"))
                            address.setStreet(jP.getString());
                        else if(keyName.equals("ward"))
                            address.setWard(jP.getString());
                        else if(keyName.equals("_id"))
                            patient.set_id(jP.getString());

                        break;
                    case START_ARRAY:
                        if (keyName.equals("tests")) {
                            tests = new ArrayList<>();
                            JsonArray jsonArray = jP.getArray();
                            for(JsonValue jV : jsonArray)
                            {
                                JsonObject jO = (JsonObject) jV;
                                Tests test = new Tests();
                                test.setTest_id(jO.getInt("test_id"));
                                test.setTest_type(jO.getString("test_type"));
                                test.setCost(jO.getJsonNumber("cost").doubleValue());
                                JsonObject jDate = jO.getJsonObject("date");
                                date = LocalDate.of(jDate.getInt("year"),
                                        jDate.getInt("month"),
                                        jDate.getInt("day"));
                                test.setDate(date);
                                test.setResult(jO.getString("result"));
                                tests.add(test);

                            }
                        } else if (keyName.equals("telephones")) {
                            telephones = new ArrayList<>();
                            JsonArray jsonArray = jP.getArray();
                            for (JsonValue jV : jsonArray) {
                                telephones.add(jV.toString());
                            }
                            patient.setTelephones((ArrayList<String>) telephones);
                        }
                        break;
                    case VALUE_NUMBER:
                        if (keyName.equals("year_of_birth")) {
                            patient.setYearOfBirth(jP.getInt());
                        }
                        break;
                        case END_OBJECT:
                            if(patient.get_id() != null && address != null && tests != null && telephones != null && patient != null) {
                                patient.setAddress(address);
                                patient.setTests((ArrayList<Tests>) tests);

                            }
                            break;
                    default:
                        break;

                }
            }
        }
        return patient;
    }
    public List<Patient> readPatients(String line, String key) throws FileNotFoundException {
        Patient patient = null;
        String keyName = "";
        List<Tests> tests = null;
        List<String> telephones = null;
        Address address = null;
        LocalDate date = null;
        List<Patient> patients = new ArrayList<>();

        try (JsonParser jP = Json.createParser(new FileReader(line))) {
            while (jP.hasNext()) {
                JsonParser.Event event = jP.next();
                switch (event) {
                    case START_OBJECT:
                        if (keyName.equals("address")) {
                            address = new Address();
                        } else {
                            patient = new Patient();

                        }
                        break;
                    case KEY_NAME:
                        keyName = jP.getString();
                        break;
                    case VALUE_STRING:
                        if ("first_name".equals(keyName)) {
                            patient.setFirstName(jP.getString());
                        } else if ("last_name".equals(keyName)) {
                            patient.setLastName(jP.getString());
                        } else if ("blood_type".equals(keyName)) {
                            patient.setBloodType(jP.getString());
                        }
                        else if(keyName.equals("gender"))
                            patient.setGender(jP.getString());
                        else if(keyName.equals("city"))
                            address.setCity(jP.getString());
                        else if(keyName.equals("district"))
                            address.setDistrict(jP.getString());
                        else if(keyName.equals("street"))
                            address.setStreet(jP.getString());
                        else if(keyName.equals("ward"))
                            address.setWard(jP.getString());
                        else if(keyName.equals("_id") && jP.getString().equals(key))
                            patient.set_id(jP.getString());

                        break;
                    case START_ARRAY:
                        if (keyName.equals("tests")) {
                            tests = new ArrayList<>();
                            JsonArray jsonArray = jP.getArray();
                            for(JsonValue jV : jsonArray)
                            {
                                JsonObject jO = (JsonObject) jV;
                                Tests test = new Tests();
                                test.setTest_id(jO.getInt("test_id"));
                                test.setTest_type(jO.getString("test_type"));
                                test.setCost(jO.getJsonNumber("cost").doubleValue());
                                JsonObject jDate = jO.getJsonObject("date");
                                date = LocalDate.of(jDate.getInt("year"),
                                        jDate.getInt("month"),
                                        jDate.getInt("day"));
                                test.setDate(date);
                                test.setResult(jO.getString("result"));
                                tests.add(test);

                            }
                        } else if (keyName.equals("telephones")) {
                            telephones = new ArrayList<>();
                            JsonArray jsonArray = jP.getArray();
                            for (JsonValue jV : jsonArray) {
                                telephones.add(jV.toString());
                            }
                            patient.setTelephones((ArrayList<String>) telephones);
                        }
                        break;
                    case VALUE_NUMBER:
                        if (keyName.equals("year_of_birth")) {
                            patient.setYearOfBirth(jP.getInt());
                        }
                        break;
                    case END_OBJECT:
                        if(patient.get_id() != null && address != null && tests != null && telephones != null && patient != null){
                            patient.setAddress(address);
                            patient.setTests((ArrayList<Tests>) tests);
                            patients.add(patient);
                        }
                        break;
                    default:
                        break;

                }
            }
        }
        return patients;
    }
    public static void exportPatient(List<Patient> patients, String line) throws IOException {
        try (JsonGenerator gen = Json.createGenerator(new FileWriter(line))) {
            gen.writeStartArray();

            for (Patient patient : patients) {
                gen.writeStartObject()
                        .write("_id", patient.get_id())
                        .write("first_name", patient.getFirstName())
                        .write("last_name", patient.getLastName())
                        .write("blood_type", patient.getBloodType())
                        .write("gender", patient.getGender())
                        .write("year_of_birth", patient.getYearOfBirth())
                        .writeStartObject("address")
                        .write("city", patient.getAddress().getCity())
                        .write("district", patient.getAddress().getDistrict())
                        .write("street", patient.getAddress().getStreet())
                        .write("ward", patient.getAddress().getWard())
                        .writeEnd()
                        .writeStartArray("telephones");
//                        .write(patient.getTelephones().get(0))
//                        .write(patient.getTelephones().get(1))
//                        .writeEnd()
//                        .writeEnd()
                for (String telephone : patient.getTelephones()) {
                    gen.write(telephone);
                }
                gen.writeEnd()
                        .writeStartArray("tests");

                patient.getTests().forEach(test -> {
                    gen.writeStartObject()
                            .write("test_id", test.getTest_id())
                            .write("test_type", test.getTest_type())
                            .write("cost", test.getCost())
                            .write("result", test.getResult())
                            .writeStartObject("date")
                            .write("year", test.getDate().getYear())
                            .write("month", test.getDate().getMonthValue())
                            .write("day", test.getDate().getDayOfMonth())
                            .writeEnd()
                            .writeEnd();
                });

                gen.writeEnd().writeEnd();
            }

            gen.writeEnd();
        }
    }

}
