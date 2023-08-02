package com.example.client.repository;

import com.example.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByFirstName(String firstName);
    Optional<Client> findByIdNumber(String idNumber);
    Optional<Client> findByPhysicalAddress(String physicalAddress);
}
