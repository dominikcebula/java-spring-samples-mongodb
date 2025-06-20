package com.dominikcebula.samples.mongodb.books;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(BooksController.API_V_1_BOOKS)
@RequiredArgsConstructor
public class BooksController {
    static final String API_V_1_BOOKS = "/api/v1/books";

    private final BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id) {
        ObjectId objectId = new ObjectId(id);

        Optional<Book> book = bookRepository.findById(objectId);

        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookCreateOrUpdateRequest request) {
        Book book = new Book(
                request.getTitle(),
                request.getAuthor(),
                request.getPublishedYear(),
                request.getGenres(),
                request.getPages()
        );

        Book savedBook = bookRepository.save(book);

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(URI.create(API_V_1_BOOKS + "/" + savedBook.getId()))
                .body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") String id, @RequestBody BookCreateOrUpdateRequest request) {
        ObjectId objectId = new ObjectId(id);

        if (!bookRepository.existsById(objectId))
            return ResponseEntity.notFound().build();

        Book book = new Book(
                objectId,
                request.getTitle(),
                request.getAuthor(),
                request.getPublishedYear(),
                request.getGenres(),
                request.getPages()
        );

        Book updatedBook = bookRepository.save(book);

        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") String id) {
        ObjectId objectId = new ObjectId(id);

        if (!bookRepository.existsById(objectId))
            return ResponseEntity.notFound().build();

        bookRepository.deleteById(objectId);

        return ResponseEntity.noContent().build();
    }
}
