package com.pdp.oidc.oidc_lab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {

    @GetMapping
    public String index(){
        return "hello";
    }

    @GetMapping
    public String index2(){
        return "hello";
    }


    @GetMapping
    public String index3(){
        return "hello";
    }

}
