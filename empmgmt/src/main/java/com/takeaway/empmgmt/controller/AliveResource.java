package com.takeaway.empmgmt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("empmgmt")
public class AliveResource {
    @GetMapping("/health")
    public String healthCheck(){
        return "I am alive";
    }
}
