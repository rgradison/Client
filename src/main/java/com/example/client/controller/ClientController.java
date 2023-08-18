package com.example.client.controller;

import com.example.client.AuthenticationResponse;
import com.example.client.model.Client;
import com.example.client.model.PhysicalAddress;
import com.example.client.service.ClientService;
import com.example.client.utils.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/client/save")
    public ResponseEntity<AuthenticationResponse> saveClient(@RequestBody Client client) throws ValidationException {
        return ResponseEntity.ok(clientService.saveClient(client));
    }

    @GetMapping("/find/by/firstname/{firstname}")
    public ResponseEntity<Optional<Client>> findByFirstName(@PathVariable final String firstname){
        return ResponseEntity.ok(clientService.findByFirstName(firstname));
    }

    @GetMapping("/find/by/id/{idnumber}")
    public ResponseEntity<Optional<Client>> findByIdNumber(@PathVariable final Long idnumber){
        return ResponseEntity.ok(clientService.findByIdNumber(idnumber));
    }

    @GetMapping("/find/by/mobilenumber/{mobileNumber}")
    public ResponseEntity<Optional<Client>> findByMobileNumber(@PathVariable final String mobileNumber){
        return ResponseEntity.ok(clientService.findByMobileNumber(mobileNumber));
    }

}
