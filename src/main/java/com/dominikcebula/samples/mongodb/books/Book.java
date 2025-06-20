package com.dominikcebula.samples.mongodb.books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private ObjectId id;
    private String title;
    private String author;
    private int publishedYear;
    private List<String> genres;
    private int pages;

    public Book(String title, String author, int publishedYear, List<String> genres, int pages) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.genres = genres;
        this.pages = pages;
    }
}
