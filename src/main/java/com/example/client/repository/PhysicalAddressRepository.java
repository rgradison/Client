package com.example.client.repository;

import com.example.client.model.PhysicalAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhysicalAddressRepository extends JpaRepository<PhysicalAddress, Long> {
    Optional<PhysicalAddress> findPhysicalAddressByIdNumber(Long idNumber);
}
