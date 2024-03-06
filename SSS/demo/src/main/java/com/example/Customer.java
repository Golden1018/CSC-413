package com.example;

// Customer Class
public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    // Constructor
    public Customer(int customerID, String firstName, String lastName, String email, String phone) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public int getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setPhone(String newPhone) {
        this.phone = newPhone;
    }
}




