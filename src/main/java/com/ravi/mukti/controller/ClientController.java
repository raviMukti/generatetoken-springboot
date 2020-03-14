package com.ravi.mukti.controller;

import com.ravi.mukti.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generate")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping(value = "/token")
    public ResponseEntity<String> generateToken(@RequestParam("key") String partnerkey, @RequestParam("url") String redirecturl){
        return new ResponseEntity<String>("Ini Token nya Kak.. " + clientService.calToken(partnerkey,redirecturl), HttpStatus.OK);
    }
}
