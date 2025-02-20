package edu.eci.cvds.tdd.library.loan;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.user.User;

import java.time.LocalDateTime;



/**
 * Represents a loan transaction for a book by a user.
 * The class tracks details about the book, the user who borrowed it, 
 * the date of the loan, the loan status, and the return date of the book.
 */
public class Loan {

    private Book book;                // The book being loaned
    private User user;                // The user borrowing the book
    private LocalDateTime loanDate;   // The date and time when the book was loaned
    private LoanStatus status;        // The current status of the loan (e.g., borrowed, returned)
    private LocalDateTime returnDate; // The date and time when the book is returned

    /**
     * Constructs a new Loan instance with the specified book, user, and loan date.
     * The status is initially set to null, and the return date is also null.
     * 
     * @param book The book being loaned.
     * @param user The user who is borrowing the book.
     * @param loanDate The date and time the loan is created.
     */
    public Loan(Book book, User user, LocalDateTime loanDate) {
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
    }

    /**
     * Retrieves the book associated with the loan.
     * 
     * @return The book being loaned.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets the book associated with the loan.
     * 
     * @param book The book to be set.
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Retrieves the user who borrowed the book.
     * 
     * @return The user who borrowed the book.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who borrowed the book.
     * 
     * @param user The user to be set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Retrieves the loan date and time.
     * 
     * @return The date and time when the loan was created.
     */
    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    /**
     * Sets the loan date and time.
     * 
     * @param loanDate The date and time to be set for the loan.
     */
    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    /**
     * Retrieves the current status of the loan (e.g., borrowed, returned).
     * 
     * @return The status of the loan.
     */
    public LoanStatus getStatus() {
        return status;
    }

    /**
     * Sets the current status of the loan.
     * 
     * @param status The status to be set for the loan.
     */
    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    /**
     * Retrieves the return date and time of the loan.
     * 
     * @return The return date and time, or null if the book has not been returned yet.
     */
    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the return date and time for the loan.
     * 
     * @param returnDate The return date and time to be set.
     */
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
