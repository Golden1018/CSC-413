/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6Model;

/**
 *
 * @author kmehta
 */
public class CustomerAddress {
    
    
    // Define variables to be used in the CustomerAddress processing 
    int streetnum, zip, id;
    String streetname, city, state;    
    
    /**
     * 5-Arg Constructor
     * 
     * @param num
     * @param street
     * @param aCity
     * @param st
     * @param zp 
     */
    public CustomerAddress(int custID, int num, String street, String aCity, String st, int zp) {
        int id = custID;
        streetnum = num;
        streetname = street;
        city = aCity;
        state = st;
        zip = zp;
    }
    
    //default constructor
    public CustomerAddress() {}
    
    //Setters and getters for the CustomerAddress
    
    public int getStreetNum() {
        return streetnum;
    }
    
    public String getStreetName() {
        return streetname;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
    
    public int getZip() {
        return zip;
    }
    
    public void setStreet(String stName) {
        this.streetname = stName;
    }
    
    public void setCity(String ct) {
        this.city = ct;
    }

    public void setState(String st) {
        this.state = st;
    }

    public void setZip(int aZip) {
        this.zip = aZip;
    }

    public void setStreetNum(int num) {
        this.streetnum = num;
    }
    
    public int getID() {
        return id;
    }
    
    public void setID(int custID) {
        this.id = custID;
    }
    
}
