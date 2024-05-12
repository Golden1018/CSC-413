/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6Model;

import java.util.*;

/**
 *
 * @author kmehta
 */
public class BankCustomer implements Comparable<BankCustomer> {

    private javax.swing.JList<BankCustomer> custList;


    
    
    // Define static variables to be used in the customer processing 
    private static ArrayList<BankCustomer> customers = new ArrayList<>();
    
    private static int custCount = 0;

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String sex;
    private String birthday;
    private int addressid;

    private String accountNumber; // Existing field
    private double balance;       // Existing field
    private String accountType;   // Added field for account type
    private String customerName;  // Added field for customer name
    


    int customerNumber;
    List accounts = new ArrayList<BankAccount>();

   

    private int custId;
    private String city;
    private String state;
    private String streetName;
    private int streetNum;
    private String zip;
    
    CustomerAddress address; // Assuming CustomerAddress is a defined class


    public BankCustomer() {}

   

    public BankCustomer(int customerNumber, String firstName, String lastName, String email, String phone) {
        System.out.println("Constructor with all details called");
        System.out.println("First Name: " + firstName + ", Last Name: " + lastName + ", Email: " + email + ", Phone: " + phone);
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this. phone = phone;
        customers.add(this);
    }
    
    

    

    public BankCustomer(int custId, String city, String state, String streetName, int streetNum, String zip) {
        this.custId = custId;
        this.city = city;
        this.state = state;
        this.streetName = streetName;
        this.streetNum = streetNum;
        this.zip = zip;
    }
    
    //2-Arg Constructor that creates a new instance, adds self to customer collection and increments the static counter
    public BankCustomer(String fName, String lName) {
        firstName = fName;
        lastName = lName;
        customers.add(this);
        customerNumber = ++custCount;
    }

    public BankCustomer(int id, String firstName, String lastName, String email, String phone, String sex, String birthday, int addressid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.birthday = birthday;
        this.addressid = addressid;
    }
    

    public BankCustomer(int custId, String city) {
        this.custId = custId;
        this.city = city;
        // Initialize other fields
    }

    public BankCustomer(int num, String fName, String lName) {
        firstName = fName;
        lastName = lName;
        customers.add(this);
        customerNumber = num;
    }    
    
    
    //All setters and getters for cusotmer 

    // Getters and setters for each field
    public int getCustId() {
        return custId;
    }

    public int getCusId() {
        return this.custId;  // Ensure this matches the name of the ID field in the BankCustomer class
    }


    

    public void setCusId(int custId) {
        this.custId = custId;
    }


    public void setCustId(int custId) {
        this.custId = custId;
    }

   

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    



    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String em) {
        email = em;
    }    
    
    public void setAddress(CustomerAddress anAddress) {
        address = anAddress;
    }
    
    
    public String getName() {
        return firstName + " " + lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setFirstName(String nm) {
        firstName = nm;
    }
    
    public void setLastName(String nm) {
        lastName = nm;
    }

    public List getAccounts() {
        return accounts;
    }
    
    public CustomerAddress getAddress() {
        return address;
    }
    
    public void setAccounts(List acts) {
        accounts = acts;
    }    
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String ph) {
        phone = ph;
    }        

    public String getBirthday() {
        return birthday;
    }
    
    public void setBirthday(String bd) {
        birthday = bd;
    }
    
    public void addAccount(BankAccount anAct) {
        accounts.add(anAct);
    }

    public static ArrayList<BankCustomer> getCustomers() {
        //Will add code later to get all bank customers from the Database
        // in collaboration with Customer DTO and DAO objects
        return customers;
    }
    
    public static int getCustCount() {
        return custCount;
    }
    
    public int getId() { // or public String getId() if ID is a string
        return id;
    }
    
    public int getCustomerNumber() {
        return customerNumber;
    }
    
    public int compareTo(BankCustomer cust) {

        int num1 = this.getCustomerNumber();
        int num2 = cust.getCustomerNumber();
        
        if(num1 == num2) return 0;
        else if(num1 > num2) return 1;
        else return -1;

    }

    

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getAccountNumber() {
        if (!accounts.isEmpty() && accounts.get(0) instanceof BankAccount) {
            return ((BankAccount) accounts.get(0)).getAccountNumber();
        }
        return null; // Handle case where there is no account or the account has no number
    }
    
    public String getPhoneNumber() {
        return this.phone;  // Assuming 'phoneNumber' is a field in BankCustomer
    }
    
    
    
    public static BankCustomerBuilder builder() {
        return new BankCustomerBuilder();
    }
    
    
    @Override
public String toString() {
    // Formatting the full address in a single line for display
    return custId + " : " + streetNum + " " + streetName + ", " + city + ", " + state + " " + zip;
}


    public String getCity() {
        return this.city;
    }

    
    

    
    
    
  
}
