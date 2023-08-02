package com.example.client.controller;

import com.example.client.model.Client;
import com.example.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    @Autowired
    private final ClientService clientService;
        
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //Create client
    @PostMapping("/save")
    public void saveClient(@RequestBody Client client){
        clientService.saveClient(client);
    }    
    
    //Retrieve client by first Name
    @GetMapping("/find/by/{firstName}")
    public ResponseEntity<Optional<Client>> findByFirstName(@PathVariable final String firstName){
        return ResponseEntity.ok(clientService.findByFirstName(firstName));
    }

    @GetMapping("/find/by/{idNumber}")
    public ResponseEntity<Optional<Client>> findByIdNumber(@PathVariable final String idNumber){
        return ResponseEntity.ok(clientService.findByIdNumber(idNumber));
    }

    @GetMapping("/find/by/{physicalAddress}")
    public ResponseEntity<Optional<Client>> findByPhysicalAddress(@PathVariable final String physicalAddress){
        return ResponseEntity.ok(clientService.findByPhysicalAddress(physicalAddress));
    }

}
