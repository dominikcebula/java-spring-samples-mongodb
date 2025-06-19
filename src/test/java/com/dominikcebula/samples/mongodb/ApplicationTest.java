package com.dominikcebula.samples.mongodb;

import com.dominikcebula.samples.mongodb.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ApplicationTest {

    private static final String HELLO_ENDPOINT = "/api/v1/books";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldRetrieveBooks() {
        List<Book> books = restTemplate.exchange(HELLO_ENDPOINT, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Book>>() {
                }).getBody();

        assertThat(books).isNotNull();
    }
}
