package com.girishms.springrestdemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    @Value("${app.name : Employee tracker}")
    private String appName;

    @Value("${app.version : version1}")
    private String version;

    @GetMapping(value = "/health")
    private String getHealth(){
        return "App Name is " + appName + " and the version is " + version;
    }

    @GetMapping("/home")
    private String home(){
        return "Hello Wo d";
    }

}
