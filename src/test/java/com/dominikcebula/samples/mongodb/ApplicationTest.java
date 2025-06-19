package com.dominikcebula.samples.mongodb;

import com.dominikcebula.samples.mongodb.dto.HelloDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ApplicationTest {

    private static final String HELLO_ENDPOINT = "/api/hello";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldRespondWithHelloMessage() {
        HelloDTO helloDTO = restTemplate.getForObject(HELLO_ENDPOINT, HelloDTO.class);

        assertThat(helloDTO.getMessage()).isEqualTo("Hello World!");
    }
}
