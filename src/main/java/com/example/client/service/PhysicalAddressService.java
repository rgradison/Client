package com.example.client.service;

import com.example.client.AuthenticationResponse;
import com.example.client.model.Client;
import com.example.client.model.PhysicalAddress;
import com.example.client.model.exception.AddressNotFoundException;
import com.example.client.repository.ClientRepository;
import com.example.client.repository.PhysicalAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class PhysicalAddressService {
    private final PhysicalAddressRepository physicalAddressRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public PhysicalAddressService(PhysicalAddressRepository physicalAddressRepository, ClientRepository clientRepository) {
        this.physicalAddressRepository = physicalAddressRepository;
        this.clientRepository = clientRepository;
    }

    public AuthenticationResponse savePhysicalAddress(PhysicalAddress physicalAddress) {
        physicalAddressRepository.save(physicalAddress);
        
        return AuthenticationResponse.builder().message(String.format("Successfully save the address.")).build();
    }

    public List<PhysicalAddress> getAllPhysicalAddress(){
        return StreamSupport.stream(physicalAddressRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public PhysicalAddress findPhysicalAddressByIdNumber(Long idNumber) {
        return physicalAddressRepository.findPhysicalAddressByIdNumber(idNumber).orElseThrow(() -> new AddressNotFoundException(idNumber) );
    }

    public PhysicalAddress deletePhysicalAddress(Long idNumber) {
        PhysicalAddress physicalAddress = findPhysicalAddressByIdNumber(idNumber);
        physicalAddressRepository.delete(physicalAddress);
        return physicalAddress;
    }

    public PhysicalAddress updatePhysicalAddress(PhysicalAddress physicalAddress, Long idNumber) {
        PhysicalAddress physicalAddressToEdit = findPhysicalAddressByIdNumber(idNumber);
        physicalAddressToEdit.setAddressNumber(physicalAddress.getAddressNumber());
        return physicalAddressToEdit;
    }

}