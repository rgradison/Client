package com.example.client.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private long id;
    @NotBlank(message = "Name is mandatory")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    @Column(unique = true)
    private String mobileNumber;
    @NotBlank(message = "Id number is mandatory")
    @Column(unique = true)
    private String idNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client() {}

    public Client(String firstName, String lastName, String mobileNumber, String idNumber, PhysicalAddress physicalAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;       
        this.idNumber = idNumber;        

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

}
