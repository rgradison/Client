package com.example.client.controller;

import com.example.client.model.Client;
import com.example.client.service.ClientService;
import com.example.client.utils.ValidationException;
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
    public void saveClient(@RequestBody Client client) throws ValidationException {

        clientService.saveClient(client);
    }    

    //Retrieve client by first Name
    @GetMapping("/find/by/firstname/{firstname}")
    public ResponseEntity<Optional<Client>> findByFirstName(@PathVariable final String firstname){
        return ResponseEntity.ok(clientService.findByFirstName(firstname));
    }

    @GetMapping("/find/by/id/{idnumber}")
    public ResponseEntity<Optional<Client>> findByIdNumber(@PathVariable final String idnumber){
        return ResponseEntity.ok(clientService.findByIdNumber(idnumber));
    }

    @GetMapping("/find/by/mobilenumber/{mobileNumber}")
    public ResponseEntity<Optional<Client>> findByMobileNumber(@PathVariable final String mobileNumber){
        return ResponseEntity.ok(clientService.findByMobileNumber(mobileNumber));
    }

}
