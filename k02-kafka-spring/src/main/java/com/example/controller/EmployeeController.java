package com.example.controller;

import com.example.domain.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    ObjectMapper mapper;

    @PostMapping("/employee")
    public String save(@RequestBody Employee employee) throws JsonProcessingException {
        String employeeText = mapper.writeValueAsString(employee);
        System.out.println(employeeText);
        this.kafkaTemplate.sendDefault(employeeText);
        return "Procesado!";
    }
}
