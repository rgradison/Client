package com.example.client.service;

import com.example.client.model.Client;
import com.example.client.repository.ClientRepository;
import com.example.client.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final PhoneNumberValidator phoneNumberValidator;
    private final IdNumberValidator idNumberValidator;
    private final FirstNameValidator firstNameValidator;
    private final LastNameValidator lastNameValidator;

    @Autowired
    public ClientService(ClientRepository clientRepository, 
                         PhoneNumberValidator phoneNumberValidator, 
                         IdNumberValidator idNumberValidator,
                         FirstNameValidator firstNameValidator,
                         LastNameValidator lastNameValidator  ) {
        
        this.clientRepository = clientRepository;
        this.phoneNumberValidator = phoneNumberValidator;
        this.idNumberValidator = idNumberValidator;
        this.firstNameValidator = firstNameValidator;
        this.lastNameValidator = lastNameValidator;
    }
    
    public void saveClient(Client client) throws ValidationException {
        String idNumber = client.getIdNumber();
        String phoneNumber = client.getMobileNumber();
        String firstName = client.getFirstName();
        String lastName = client.getLastName();

        if(IdNumberValidator.validateSAID(idNumber) && phoneNumberValidator.validatePhoneNumber(phoneNumber) 
                && firstNameValidator.validateFirstName(firstName)
                && lastNameValidator.validateLastName(lastName))  {

            clientRepository.save(client);
        }
    }

    public Optional<Client> findByFirstName(String firstName) {
        return clientRepository.findByFirstName(firstName);
    }

    public Optional<Client> findByIdNumber(String idNumber) {
        return clientRepository.findByIdNumber(idNumber);
    }

    public Optional<Client> findByMobileNumber(String mobileNumber) {
        return clientRepository.findByMobileNumber(mobileNumber);
    }
    
}