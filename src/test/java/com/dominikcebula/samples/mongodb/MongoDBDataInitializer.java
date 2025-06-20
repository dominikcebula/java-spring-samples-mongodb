package com.dominikcebula.samples.mongodb;

import com.dominikcebula.samples.mongodb.entity.Book;
import com.dominikcebula.samples.mongodb.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@TestConfiguration
public class MongoDBDataInitializer {

    public static final List<Book> BOOKS = List.of(
            new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, List.of("Classic", "Fiction"), 218),
            new Book("1984", "George Orwell", 1949, List.of("Dystopian", "Science Fiction"), 328),
            new Book("To Kill a Mockingbird", "Harper Lee", 1960, List.of("Classic", "Coming-of-Age", "Social Issues"), 281),
            new Book("The Hobbit", "J.R.R. Tolkien", 1937, List.of("Fantasy", "Adventure"), 310),
            new Book("Pride and Prejudice", "Jane Austen", 1813, List.of("Romance", "Classic", "Satire"), 279)
    );

    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository) {
        return args -> {
            bookRepository.deleteAll();

            bookRepository.saveAll(BOOKS);
        };
    }
}
