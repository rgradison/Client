package com.example.client.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@Data
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

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<PhysicalAddress> physicalAddress = new ArrayList<>();

    public Client(String firstName, String lastName, String mobileNumber, String idNumber, List<PhysicalAddress> physicalAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;       
        this.idNumber = idNumber;        
        this.physicalAddress = physicalAddress;
    }

    public Client() {}

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void addPhysicalAddress(PhysicalAddress physicalAddress){
        this.physicalAddress.add(physicalAddress);
    }
    
     public void removePhysicalAddress(PhysicalAddress physicalAddress){
        this.physicalAddress.remove(physicalAddress);
    }

}