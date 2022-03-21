package com.example;

import com.example.kafka.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerTest {

    @Autowired
    Producer producer;

    @Test
    void sendString() {
        producer.sendString();
    }

    @Test
    void sendCustomer() throws JsonProcessingException {
        producer.sendCustomer();
    }
}