package com.finance.frauddetection.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraud-alerts")

public class FraudAlertController {


    @GetMapping
    public String getAll() {
        return "All Fraud List";
    }

    @PutMapping("/{id}/status")
    public String updateStatus(@PathVariable int id) {

        return "Alert status updated here for " + id ;
    }
}