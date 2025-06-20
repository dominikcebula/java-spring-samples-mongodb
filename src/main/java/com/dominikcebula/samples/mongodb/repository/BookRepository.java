package com.dominikcebula.samples.mongodb.repository;

import com.dominikcebula.samples.mongodb.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, ObjectId> {
}
