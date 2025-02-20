package edu.eci.cvds.tdd.library.book;

/**
 * Represents a Book with a title, author, and ISBN.
 * This class provides methods to retrieve these details and compare books based on their ISBN.
 */
public class Book {

    private final String tittle;  // Title of the book
    private final String author;  // Author of the book
    private final String isbn;    // ISBN number of the book

    /**
     * Constructs a new Book with the specified title, author, and ISBN.
     * 
     * @param tittle The title of the book.
     * @param author The author of the book.
     * @param isbn The ISBN number of the book.
     */
    public Book(String tittle, String author, String isbn) {
        this.tittle = tittle;
        this.author = author;
        this.isbn = isbn;
    }

    /**
     * Retrieves the title of the book.
     * 
     * @return The title of the book.
     */
    public String getTittle() {
        return tittle;
    }

    /**
     * Retrieves the author of the book.
     * 
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Retrieves the ISBN of the book.
     * 
     * @return The ISBN number of the book.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Compares this book with another book to see if they are equal.
     * Two books are considered equal if they have the same ISBN.
     * 
     * @param obj The object to compare with.
     * @return true if the books have the same ISBN, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        return isbn.equals(((Book) obj).isbn);
    }
}
