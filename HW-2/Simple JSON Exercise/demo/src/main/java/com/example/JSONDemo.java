/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example;

import java.lang.*;
import java.io.*;
import java.util.List;
import java.util.Iterator;
import java.net.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;


import javax.json.stream.*;
import javax.json.JsonReader;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.Json;


 /*
 * @author karunmehta
 */
public class JSONDemo {

    static ObjectMapper objectMapper = null;

    static String jsonEmployeeString = "{ \"username\" : \"John Doe\", \"email\" : \"jdoe@sfsu.edu\", \"phone\" : \"777-1212\", \"id\" : \"100\" }";
    static String jsonEmployeesString =
        "[{ \"username\" : \"James Madison\", \"email\" : \"jmadison@sfsu.edu\", \"phone\" : \"777-1212\", \"id\" : \"200\" },\n" +
        "{ \"username\" : \"James Matteson\", \"email\" : \"jmatteson@sfsu.edu\", \"phone\" : \"555-1212\", \"id\" : \"400\" },\n" +
        "{ \"username\" : \"Hsin Ying Tsai\", \"email\" : \"htsai1@sfsu.edu\", \"phone\" : \"281-9579\", \"id\" : \"878\" }]";
    
    public static void main(String[] args) {

        // Parse JSON string to JsonNode
        objectMapper = new ObjectMapper();
        
        System.out.println("\nCreating Employee object"); 
        
        //create Employee object
        Employee emp = new Employee("Paula Abdul", "pabdul@sfsu.edu");
        String empString = ""; 
        
        //create string version of the employee object
        try {
            empString = objectMapper.writeValueAsString(emp);
        } catch (JsonProcessingException jpe) {
            System.out.println(jpe.getMessage());
        }
        
        System.out.println("\nJSON String version of Employee object\n" + empString);
        
        
        //Read in employee strings as json tree
        try {
            JsonNode jsonNode1 = objectMapper.readTree(jsonEmployeeString);
            JsonNode jsonNode2 = objectMapper.readTree(jsonEmployeesString);

            // Accessing JSON properties
            String name = jsonNode1.get("username").asText();
            String email = jsonNode1.get("email").asText();
            String phone = jsonNode1.get("phone").asText();
            String id = jsonNode1.get("id").asText();
            
            System.out.println("\nSingle Employee Detail JSON String:");
            String treeString = jsonNode1.toPrettyString();
            System.out.println(treeString);
            
            System.out.println("\nMultiple Employee Detail JSON String:");
            treeString = jsonNode2.toPrettyString();
            System.out.println(treeString);
            
            System.out.println("\nNow printing each employee detail: ");
            
            Iterator it = jsonNode2.elements();
            while(it.hasNext()) {
                
                JsonNode jNode = (JsonNode)it.next();

                // Printing JSON properties for the current node
                System.out.println("\nName: " + jNode.get("username").asText());
                System.out.println("email1: " + jNode.get("email").asText());
                System.out.println("phone1: " + jNode.get("phone").asText());
                System.out.println("Id1: " + jNode.get("id").asText());
            
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Working with Employee Objects
        readJsonEmployee();
        readJsonEmployees();
        //readJsonStream();
    }
    
    public static void readJsonStream() {

        URL url = null;
        JsonReader rdr = null;
        
        try {
            
            url = new URL("https://developers.facebook.com/docs/graph-api");
        
        } catch(MalformedURLException me) {
                
            me.printStackTrace();
                
        }
        
        try {
        
            InputStream is = url.openStream();        
            rdr = Json.createReader(is);   
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        JsonArray obj;
        obj = rdr.readArray();
        JsonArray results = obj.getJsonArray(1);
        for (JsonObject result : results.getValuesAs(JsonObject.class)) {
             System.out.print(result.getJsonObject("from").getString("name"));
             System.out.print(": ");
             System.out.println(result.getString("message", ""));
             System.out.println("-----------");
         }
    }        
   
    public static void readJsonEmployee() {

        Employee empObj = null;
        
        try {
            empObj = objectMapper.readValue(jsonEmployeeString, Employee.class);
        } catch(JsonProcessingException jpe) {
            System.out.println(jpe.getMessage());
        }
        
        //Getting data from Employee object created from JSON String
        System.out.println("\nReading data from JSON String of single employee:"); 
        if (empObj != null) {
            System.out.println("Name: " + empObj.getUsername());
            System.out.println("Email: " + empObj.getEmail());
            System.out.println("Phone: " + empObj.getPhone());
            System.out.println("ID: " + empObj.getID());
        }
    }

    public static void readJsonEmployees() {

        List<Employee> empList = null;
        
        try {
            empList = objectMapper.readValue(jsonEmployeesString,new TypeReference<List<Employee>>(){});
        } catch(JsonProcessingException jpe) {
            System.out.println(jpe.getMessage());
        }

        Iterator it = empList.iterator();
        
        System.out.println("\nReading data from multiple employees in JSON array:"); 
        
        while(it.hasNext()) {
            
            Employee emp = (Employee)it.next();
            System.out.println("Name: " + emp.getUsername());
            System.out.println("Email: " + emp.getEmail());
            System.out.println("Phone: " + emp.getPhone());
            System.out.println("ID: " + emp.getID() + "\n");
        }

    }     
    
}
