db = db.getSiblingDB('books');

db.books.drop();

db.books.insertMany([
    {
        title: "The Great Gatsby",
        author: "F. Scott Fitzgerald",
        publishedYear: 1925,
        genres: ["Classic", "Fiction"],
        pages: 218
    },
    {
        title: "1984",
        author: "George Orwell",
        publishedYear: 1949,
        genres: ["Dystopian", "Science Fiction"],
        pages: 328
    },
    {
        title: "To Kill a Mockingbird",
        author: "Harper Lee",
        publishedYear: 1960,
        genres: ["Classic", "Coming-of-Age", "Social Issues"],
        pages: 281
    },
    {
        title: "The Hobbit",
        author: "J.R.R. Tolkien",
        publishedYear: 1937,
        genres: ["Fantasy", "Adventure"],
        pages: 310
    },
    {
        title: "Pride and Prejudice",
        author: "Jane Austen",
        publishedYear: 1813,
        genres: ["Romance", "Classic", "Satire"],
        pages: 279
    }
]);