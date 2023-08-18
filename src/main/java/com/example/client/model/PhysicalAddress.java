package com.example.client.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@Entity
public class PhysicalAddress {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id",nullable = false, referencedColumnName = "id", unique = true)
    private Client client;

    private String addressNumber;
    private String addressTypeCode;
    private String city;
    private String country;
    private String costalCode;
    private Long idNumber;

    public PhysicalAddress() {}

    public PhysicalAddress(String addressNumber, String addressTypeCode, String city, String country, String costalCode, Long idNumber) {
        this.addressNumber = addressNumber;
        this.addressTypeCode = addressTypeCode;
        this.city = city;
        this.country = country;
        this.costalCode = costalCode;
        this.idNumber = idNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressTypeCode() {
        return addressTypeCode;
    }

    public void setAddressTypeCode(String addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCostalCode() {
        return costalCode;
    }

    public void setCostalCode(String costalCode) {
        this.costalCode = costalCode;
    }
    
    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

}
