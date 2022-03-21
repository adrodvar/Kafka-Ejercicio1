package com.example.kafka;

import com.example.domain.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    ObjectMapper mapper;


    public void sendString(){
        this.kafkaTemplate.sendDefault("Hola desde Spring!");
    }

    public void sendCustomer() throws JsonProcessingException {
        Customer customer = new Customer(9L, "customer1", 50000.0);

        String customerText = mapper.writeValueAsString(customer);
        System.out.println(customerText);

        this.kafkaTemplate.sendDefault(customerText);
    }
}
