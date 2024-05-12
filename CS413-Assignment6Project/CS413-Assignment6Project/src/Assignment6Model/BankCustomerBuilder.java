/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Model;

import java.util.ArrayList;

/**
 *
 * @author karunmehta
 */

    // BankCustomerBuilder interface

    public class BankCustomerBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private ArrayList<CustomerAddress> addresses;
        private String custBirthday;

        public BankCustomerBuilder () {
        }
        
        public BankCustomerBuilder (String fn, String ln) {
            this.firstName = fn;
            this.lastName = ln;
        }

        public BankCustomerBuilder(String fn, String ln, String ph, ArrayList addr, String em) {
            this.firstName = fn;
            this.lastName = ln;
            this.phoneNumber = ph;
            this.addresses = addr;
            email = em;
            
        }
        
        public void address(ArrayList addrList) {
            addresses = addrList;

        } 
        public BankCustomerBuilder email(String email) {
            this.email = email;
            return this;
        }

        public BankCustomerBuilder phoneNumber(String phoneNumber) {
            phoneNumber = phoneNumber;
            return this;
        }
        
        public String firstName() {
            return firstName;
        }

        public String lastName() {
            return lastName;
        }
        
        public String phone() {
            return phoneNumber;
        }

        public ArrayList addresses() {
            return addresses;
        }

        public String email() {
            return email;
        }        
        
        public void build(String fn, String ln, String ph, ArrayList addr, String em) {
           
       }
        
    }
