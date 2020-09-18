package com.ravi.mukti.controller;

import com.ravi.mukti.service.impl.BaseGeneratorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generate")
public class GeneratorController {
    @Autowired
    BaseGeneratorImpl baseGeneratorImpl;

    @GetMapping(value = "/token")
    public ResponseEntity<String> generateToken(@RequestParam("key") String partnerkey, @RequestParam("url") String redirecturl){
        return new ResponseEntity<String>("Ini Token nya Kak.. " + baseGeneratorImpl.calToken(partnerkey,redirecturl), HttpStatus.OK);
    }

    @GetMapping(value = "/link-generator")
    public ResponseEntity<String> generateLink(@RequestParam("partnerId") Integer partnerId, @RequestParam("partnerKey") String partnerKey){
        return new ResponseEntity<String>("Ini Link nya : " + baseGeneratorImpl.generateLink(partnerId, partnerKey), HttpStatus.OK);
    }
}
