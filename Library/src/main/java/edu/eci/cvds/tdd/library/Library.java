package edu.eci.cvds.tdd.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import java.time.LocalDateTime;

/**
 * Represents a Library system responsible for managing users, books, and loans.
 * The library allows adding books, lending books to users, and returning books, 
 * along with handling various validation checks for each operation.
 */
public class Library {

    private final List<User> users;               // List of users in the library
    public final Map<Book, Integer> books;        // Map of books and their available quantities
    final List<Loan> loans;                       // List of active and past loans

    /**
     * Constructs a new Library instance.
     * Initializes the lists of users, books, and loans.
     */
    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    /**
     * Adds a new book to the library's collection.
     * If the book already exists in the library, its available quantity is increased by 1.
     * If the book is new, it is added with a quantity of 1.
     * 
     * @param book The book to store in the library's collection.
     * @return true if the book was successfully added, false otherwise.
     */
    public boolean addBook(Book book) {
        if(books.containsKey(book)){
            books.put(book, books.get(book) + 1);
            return true;
        } else {
            books.put(book, 1);
            return true;
        }
    }

    /**
     * Creates a new loan for the user with the specified userId and book identified by its ISBN.
     * Before creating the loan, the system checks whether the book is available, whether the user exists, 
     * and whether the user doesn't already have an active loan for the same book.
     * If all conditions are met, the loan is created with an ACTIVE status and the book's quantity is decreased by 1.
     * 
     * @param userId The ID of the user borrowing the book.
     * @param isbn The ISBN of the book being borrowed.
     * @return The newly created loan if successful, or null if any validation fails.
     */
    public Loan loanABook(String userId, String isbn) {
        User user = null;
        for(User u: users){
            if(u.getId().equals(userId)){
                user = u;
            }
        }

        Book book = null;
        for(Book b: books.keySet()){
            if(b.getIsbn().equals(isbn)){
                book = b;
            }
        }

        // Validate if the book is available, user exists, and no double loans exist
        Boolean disponible = libroDisponible(isbn);
        Boolean usuario = usuarioExistente(userId);
        Boolean prestamo = prestamoDoble(user, book);

        // Create loan if all conditions are met
        if(disponible && usuario && prestamo){
            Loan loan = new Loan(book, user, LocalDateTime.now());
            loan.setStatus(LoanStatus.ACTIVE);
            books.put(book, books.get(book) - 1);
            loans.add(loan);
            return loan;
        }
        return null;
    }

    /**
     * Checks whether a user already has an active loan for a given book.
     * 
     * @param user The user who is attempting to borrow the book.
     * @param book The book the user wants to borrow.
     * @return true if the user does not have an active loan for the book, false otherwise.
     */
    public boolean prestamoDoble(User user, Book book) {
        int count = 0;
        for(Loan l: loans){
            if(l.getUser().equals(user) && l.getBook().equals(book)){
                count++;
            }
        }
        return count == 0;  // Return true if no active loan exists
    }

    /**
     * Checks if a book is available to be loaned.
     * 
     * @param isbn The ISBN of the book to check.
     * @return true if the book is available (quantity > 0), false otherwise.
     */
    public boolean libroDisponible(String isbn) {
        for (Book b : books.keySet()) {
            if (b.getIsbn().equals(isbn) && books.get(b) > 0) {
                return true;
            }
        }
        return false;  // Book is not available
    }

    /**
     * Checks whether a user exists in the library system.
     * 
     * @param userId The ID of the user to check.
     * @return true if the user exists, false otherwise.
     */
    public boolean usuarioExistente(String userId) {
        for (User b : users) {
            if (b.getId().equals(userId)) {
                return true;  // User exists
            }
        }
        return false;  // User does not exist
    }

    /**
     * Returns a loan and marks the book as returned.
     * The status of the loan is updated to RETURNED and the return date is set to the current date.
     * The quantity of the book is increased by 1 to reflect its return.
     * 
     * @param loan The loan to return.
     * @return The loan with the RETURNED status, or null if the loan doesn't exist.
     */
    public Loan returnLoan(Loan loan) {
        if (loan == null) {
            return null;  // Return null if the loan does not exist
        }

        Book book = loan.getBook();
        books.put(book, books.get(book) + 1);
        loan.setStatus(LoanStatus.RETURNED);
        loan.setReturnDate(LocalDateTime.now());
        return loan;
    }

    /**
     * Adds a new user to the library system.
     * 
     * @param user The user to add to the library.
     * @return true if the user was successfully added, false otherwise.
     */
    public boolean addUser(User user) {
        return users.add(user);
    }
}
