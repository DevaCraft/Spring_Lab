package com.pdp.oidc.oidc_lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevCOntroller {

    @GetMapping
    public String index(){
        return "hello";
    }

}
