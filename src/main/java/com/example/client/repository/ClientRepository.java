package com.example.client.repository;


import com.example.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//We have extended this interface with JPARepository interface which will provide built-in methods to interact with the
// database also we can define finder methods. We have defined 3 finder methods findFirstByName(), etc
// which will return the List<Laptops>

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    //localhost:8080/api/v1/client/find/by/firstname/King
    //Instead you can use native sql query which is more easier to use. here '?' stands for the parameter that you are passing.
    //@Query(value = "SELECT * FROM client WHERE firstname=?",nativeQuery = true)
    Optional<Client> findByFirstName(String firstName);
    Optional<Client> findByIdNumber(Long idNumber);
    Optional<Client> findByMobileNumber(String mobileNumber);
}
