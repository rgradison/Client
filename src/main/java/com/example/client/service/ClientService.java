package com.example.client.service;

import com.example.client.AuthenticationResponse;
import com.example.client.model.Client;
import com.example.client.model.PhysicalAddress;
import com.example.client.model.exception.ClientNotFoundException;
import com.example.client.repository.ClientRepository;
import com.example.client.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final PhoneNumberValidator phoneNumberValidator;
    private final FirstNameValidator firstNameValidator;
    private final LastNameValidator lastNameValidator;
    private final PhysicalAddressService physicalAddressService;

    @Autowired
    public ClientService(ClientRepository clientRepository, 
                         PhoneNumberValidator phoneNumberValidator,
                         FirstNameValidator firstNameValidator,
                         LastNameValidator lastNameValidator,
                         PhysicalAddressService physicalAddressService) {
        
        this.clientRepository = clientRepository;
        this.phoneNumberValidator = phoneNumberValidator;
        this.firstNameValidator = firstNameValidator;
        this.lastNameValidator = lastNameValidator;
        this.physicalAddressService = physicalAddressService;
    }
    
    public AuthenticationResponse saveClient(Client client) throws ValidationException {
        String idNumber = client.getIdNumber();
        String phoneNumber = client.getMobileNumber();
        String firstName = client.getFirstName();
        String lastName = client.getLastName();

        if(IdNumberValidator.validateSAID(idNumber) && phoneNumberValidator.validatePhoneNumber(phoneNumber)
                && firstNameValidator.validateFirstName(firstName)
                && lastNameValidator.validateLastName(lastName))  {

           clientRepository.save(client);
           return AuthenticationResponse.builder().message(String.format("Successfully saved the client.")).build();
           
        }else {
            return AuthenticationResponse.builder()
                   .message(String.format("Failed to save the client again."))
                   .build();
        }
    }

    public Optional<Client> findByFirstName(String firstName) {
        return clientRepository.findByFirstName(firstName);
    }

    public Optional<Client> findByMobileNumber(String mobileNumber) {
        return clientRepository.findByMobileNumber(mobileNumber);
    }

    public List<Client> getAllClients() {
        return StreamSupport.stream(clientRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Optional<Client> findByIdNumber(Long idNumber) {
        return Optional.ofNullable(clientRepository.findByIdNumber(idNumber).orElseThrow(() -> new ClientNotFoundException(idNumber)));
    }

    public Optional<Client> deleteClientByIdNumber(Long idNumber) {
        Optional<Client> client = findByIdNumber(idNumber);
        clientRepository.delete(client.get());
        return client;
    }

    public Optional<Client> updateClient(Client client, Long idNumber) {
        Client clientToEdit = findByIdNumber(idNumber).get();
        clientToEdit.setFirstName(client.getFirstName());
        return Optional.of(clientToEdit);
    }

    public Client addPhysicalAddressToClient(Long clientId, Long physicalAddressId) {
        Client client = findByIdNumber(clientId).get();
        PhysicalAddress physicalAddress = physicalAddressService.findPhysicalAddressByIdNumber(physicalAddressId);//physicalAddressRepository.findById(physicalAddressId).get();
        client.addPhysicalAddress(physicalAddress);
        return client;
    }

    public Client removePhysicalAddressFromClient(Long clientId, Long physicalAddressId) {
        Client client = findByIdNumber(clientId).get();
        PhysicalAddress physicalAddress = physicalAddressService.findPhysicalAddressByIdNumber(physicalAddressId);
        client.removePhysicalAddress(physicalAddress);
        return client;
    }
    
}