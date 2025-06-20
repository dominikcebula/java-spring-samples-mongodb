package com.dominikcebula.samples.mongodb;

import com.dominikcebula.samples.mongodb.books.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Arrays;
import java.util.List;

import static com.dominikcebula.samples.mongodb.MongoDBDataInitializer.BOOKS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
@Import({MongoDBConfiguration.class, MongoDBDataInitializer.class})
class ApplicationTest {
    private static final String BOOKS_ENDPOINT = "/api/v1/books";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldRetrieveAllBooks() {
        // when
        ResponseEntity<List<Book>> response = restTemplate.exchange(
                BOOKS_ENDPOINT,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Book>>() {
                }
        );

        // then
        assertThat(response.getStatusCode()).isEqualTo(OK);
        List<Book> books = response.getBody();
        assertThat(books)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .containsAll(BOOKS);
    }

    @Test
    void shouldRetrieveExistingBookById() {
        // given
        Book bookToRetrieve = BOOKS.get(2);

        // when
        ResponseEntity<Book> response = restTemplate.getForEntity(
                BOOKS_ENDPOINT + "/" + bookToRetrieve.getId(),
                Book.class
        );

        // then
        assertThat(response.getStatusCode()).isEqualTo(OK);
        Book retrievedBook = response.getBody();
        assertThat(retrievedBook)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(bookToRetrieve);
    }

    @Test
    void shouldNotRetrieveNonExistentBook() {
        // when
        ResponseEntity<Book> response = restTemplate.getForEntity(
                BOOKS_ENDPOINT + "/000000000000000000000000",
                Book.class
        );

        // then
        assertThat(response.getStatusCode()).isEqualTo(NOT_FOUND);
    }

    @Test
    @DirtiesContext
    void shouldCreateNewBook() {
        // given
        Book bookToCreated = new Book(
                "The Lord of the Rings",
                "J.R.R. Tolkien",
                1954,
                Arrays.asList("Fantasy", "Adventure"),
                1178
        );

        // when
        ResponseEntity<Book> createResponse = restTemplate.postForEntity(
                BOOKS_ENDPOINT,
                bookToCreated,
                Book.class
        );

        // then
        assertThat(createResponse.getStatusCode()).isEqualTo(CREATED);
        Book createdBook = createResponse.getBody();
        assertThat(createdBook).isNotNull();
        assertThat(createdBook.getId()).isNotNull();
        assertThat(createdBook)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(bookToCreated);
    }

    @Test
    @DirtiesContext
    void shouldDeleteExistingBook() {
        // given
        Book bookToDelete = BOOKS.get(1);

        // when
        ResponseEntity<Void> deleteResponse = restTemplate.exchange(
                BOOKS_ENDPOINT + "/" + bookToDelete.getId(),
                HttpMethod.DELETE,
                null,
                Void.class
        );

        // then
        assertThat(deleteResponse.getStatusCode()).isEqualTo(NO_CONTENT);
        assertBookNoLongerAvailable(bookToDelete);
    }

    private void assertBookNoLongerAvailable(Book bookToDelete) {
        ResponseEntity<Book> getResponse = restTemplate.getForEntity(
                BOOKS_ENDPOINT + "/" + bookToDelete.getId(),
                Book.class
        );
        assertThat(getResponse.getStatusCode()).isEqualTo(NOT_FOUND);
    }
}
