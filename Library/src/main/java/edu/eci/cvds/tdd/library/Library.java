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
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    public final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    /**
     * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the book is store in a Map that contains
     * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books available, if the book already exist the
     * amount should increase by 1 and if the book is new the amount should be 1, this method returns true if the
     * operation is successful false otherwise.
     *
     * @param book The book to store in the map.
     *
     * @return true if the book was stored false otherwise.
     */
    public boolean addBook(Book book) {
        try {
            if(books.containsKey(book)){
                books.put(book, books.get(book) + 1);

            }else{
                books.put(book, 1);
                return true;
            }
            return true;
        } catch (Exception e){
            return false;
        }
    
    }

    /**
     * This method creates a new loan with for the User identify by the userId and the book identify by the isbn,
     * the loan should be store in the list of loans, to successfully create a loan is required to validate that the
     * book is available, that the user exist and the same user could not have a loan for the same book
     * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these requirements are meet the amount of books is
     * decreased and the loan should be created with {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
     * the loan date should be the current date.
     *
     * @param userId id of the user.
     * @param isbn book identification.
     *
     * @return The new created loan.
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

        //Validación de libro disponible

        Boolean disponible,usuario, prestamo;
        disponible = libroDisponible(isbn);
        //validación usuario existente
        usuario = usuarioExistente(userId);


        //valicación prestamo doble
        prestamo = prestamoDoble(user, book);

        //Realizar prestamo 
        if(disponible == true && usuario == true && prestamo == true){
            Loan loan = new Loan(book,user,  LocalDateTime.now());
            loan.setStatus(LoanStatus.ACTIVE);
            books.put(book, books.get(book) - 1);
            return loan;
        }
        return null;
       
   
    }


    public boolean prestamoDoble(User user, Book book){
        
        int count = 0;
        for(Loan l: loans){
            if(l.getUser().equals(user) && l.getBook().equals(book)){
                count ++;
            
            }
        }
        if(count > 0){
            return false;
        }else{
            return true;
        }
        
    }

    public boolean libroDisponible(String isbn) {
        for (Book b : books.keySet()) {
            if (b.getIsbn().equals(isbn) && books.get(b) > 0) {
                return true; 
            }
        }
        return false; 
    }


    public boolean usuarioExistente(String userId) {
        for (User b : users) {
            if (b.getId().equals(userId)) {
                return true; 
            }
        }
        return false; 
    }


    /**
     * This method return a loan, meaning that the amount of books should be increased by 1, the status of the Loan
     * in the loan list should be {@link edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
     * date should be the current date, validate that the loan exist.
     *
     * @param loan loan to return.
     *
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        //TODO Implement the login of loan a book to a user based on the UserId and the isbn.
        return null;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }


     
}