package com.dominikcebula.samples.mongodb.books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateOrUpdateRequest {
    private String title;
    private String author;
    private int publishedYear;
    private List<String> genres;
    private int pages;
}