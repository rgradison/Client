package com.example.client.service;

import com.example.client.model.Client;
import com.example.client.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public Optional<Client> findByFirstName(String firstName) {
        return clientRepository.findByFirstName(firstName);
    }

    public Optional<Client> findByIdNumber(String idNumber) {
        return clientRepository.findByIdNumber(idNumber);
    }

    public Optional<Client> findByPhysicalAddress(String physicalAddress) {
        return clientRepository.findByPhysicalAddress(physicalAddress);
    }
    
}