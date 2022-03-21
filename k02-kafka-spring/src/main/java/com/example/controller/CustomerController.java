package com.example.controller;

import com.example.domain.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    ObjectMapper mapper;

    @PostMapping("/customers")
    public String save(@RequestBody Customer customer) throws JsonProcessingException {
        String customerText = mapper.writeValueAsString(customer);
        System.out.println(customerText);
        this.kafkaTemplate.sendDefault(customerText);
        return "Procesado!";
    }
}
