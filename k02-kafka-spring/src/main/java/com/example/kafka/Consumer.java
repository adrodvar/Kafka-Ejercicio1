package com.example.kafka;

import com.example.Entity.EmployeeEntity;
import com.example.Entity.EmployeeRepository;
import com.example.domain.Customer;
import com.example.domain.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private final EmployeeRepository repository;

    @Autowired
    ObjectMapper mapper;

    public Consumer(EmployeeRepository repository) {
        this.repository = repository;
    }
/*
    @KafkaListener(topics = {"springtopic"})
    public void onCustomerSave(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        System.out.println(consumerRecord);
        String value = consumerRecord.value();
        // Pasar de json string a objeto java
        Customer customer = mapper.readValue(value, Customer.class);
        System.out.println("Consumer test: "+ customer);
    }*/

    @KafkaListener(topics = {"springtopic"})
    public void onCEmployeeSave(ConsumerRecord<String, String> employeeRecord) throws JsonProcessingException {
        System.out.println(employeeRecord);
        String value = employeeRecord.value();
        Employee employee = mapper.readValue(value, Employee.class);
        EmployeeEntity employeeEntity = new EmployeeEntity(employee.id(),employee.name(), employee.phone(), employee.passport());
        repository.save(employeeEntity);
        System.out.println("Entity: "+ employeeEntity);
        System.out.println("employee test: "+ employee);
    }
}
