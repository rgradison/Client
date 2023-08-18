package com.example.client.controller;

import com.example.client.AuthenticationResponse;
import com.example.client.model.PhysicalAddress;
import com.example.client.service.PhysicalAddressService;
import com.example.client.utils.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class PhysicalAddressController {
    private final PhysicalAddressService physicalAddressService;

    public PhysicalAddressController(PhysicalAddressService physicalAddressService) {
        this.physicalAddressService = physicalAddressService;
    }
    
    @PostMapping("/physicaladdress/save")
    public ResponseEntity<AuthenticationResponse> savePhysicalAddress(@RequestBody PhysicalAddress physicalAddress) throws ValidationException {
        return ResponseEntity.ok(physicalAddressService.savePhysicalAddress(physicalAddress));
    }


}
