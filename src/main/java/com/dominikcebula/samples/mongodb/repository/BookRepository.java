package com.dominikcebula.samples.mongodb.repository;

import com.dominikcebula.samples.mongodb.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BookRepository extends MongoRepository<Book, UUID> {
}
