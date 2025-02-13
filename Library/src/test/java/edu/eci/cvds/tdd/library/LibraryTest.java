package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest{

    private Library library;
    private Book book, book2, book3;
    private User user, user2;

    /**
     * We decided to implement the following code structure in order to be able to execute good practices such as avoiding 
     * writing the same code fragments
     */
    @Before
    public void setUp() {
        library = new Library();
        book = new Book("Prueba", "Ivan", "123");
        book2 = new Book("Prueba2", "Camilo", "124");
        book3 = new Book("Prueba3","usuario","1");
        user = new User("Camilo","12345");
        user2 = new User("Ivan","007");
        library.addBook(book);
        library.addUser(user);
    }

    /** 
     * This test tests the method add a new book  
     * */
    @Test
    public void testAddBook() {
        assertTrue(library.addBook(book2));
    }

    /**
     * this test tests the method who pretends counting amount when the same book is added
     */
    @Test
    public void testAddCorrectAmount(){
        library.addBook(book2);
        library.addBook(book2);
        assertTrue(library.books.get(book2)==2);
    }

    /**
     * This test tests the method who simulates a successfull loan of a book
     */
    @Test 
    public void testSuccessfullLoan(){
        library.addBook(book2);
        assertNotNull(library.loanABook(user.getId(),book2.getIsbn()));
    }

     /**
     * This test tests the method who simulates a not successfull loan of a book
     */
    @Test
    public void testLoanBookNotAvailable(){
        assertNull(library.loanABook(user2.getId(),book2.getIsbn()));
    }

     /**
     * This test tests the method which return a book
     */
    @Test 
    public void testGetBook(){
        library.addBook(book2);
        library.addUser(user2);
        assertEquals(library.loanABook(user2.getId(),book2.getIsbn()).getBook(),book2);
    }

    /**
    * This test tests the method which return a user
    */
    @Test 
    public void testGetUser(){
        library.addBook(book2);
        assertEquals(library.loanABook(user.getId(),book2.getIsbn()).getUser(),user);
    }

     /**
     * This test tests the method which return a loan date in a existing loan
     */
    @Test 
    public void testGetLoanDate(){
        library.addBook(book2);
        assertNotNull(library.loanABook(user.getId(),book2.getIsbn()).getLoanDate());
    }

    /**
     * This test tests the method which set a user name in a existing user
     */
    @Test 
    public void testUserSetName(){
        user.setName("Ivan");
        assertEquals(user.getName(),"Ivan");
    }

    /**
     * This test tests the method which set a userID in a existing user
     */
    @Test 
    public void testUserSetId(){
        user.setId("1");
        assertEquals(user.getId(),"1");
    }

    /**
     * This test tests the method which get a user name in a existing user
     */
    @Test 
    public void testGetNameUser(){
        assertEquals(user.getName(),"Camilo");
    }

    /**
     * This test tests the method which get a book title in an existing book
     */
    @Test 
    public void testGetTittle(){
        assertEquals(book.getTittle(),"Prueba");
    }

     /**
     * This test tests the method which gets a book author in an existing book
     */
    @Test 
    public void testAuthorTittle(){
        library.addBook(book2);
        assertEquals(book2.getAuthor(),"Camilo");
    }

     /**
     * This test tests the method that sets a new book on existing loan
     */
    @Test
    public void testSetBookLoan(){
        library.addBook(book2);
        library.addUser(user2);
        LocalDateTime loanDate = LocalDateTime.now();
        Loan loan = new Loan(book, user2, loanDate);
        loan.setBook(book2);
        assertEquals(loan.getBook(),book2);
    }

    /**
     * This test tests the method that sets a new user on existing loan
     */
    @Test
    public void testSetUserLoan(){
        library.addUser(user2);
        LocalDateTime loanDate = LocalDateTime.now();
        Loan loan = new Loan(book, user, loanDate);
        loan.setUser(user2);
        assertEquals(loan.getUser(),user2);
    }

     /**
     * This test tests the method that sets a new Loan Date on existing loan
     */
    @Test
    public void testSetLoanDate(){
        LocalDateTime loanDate = LocalDateTime.now();
        Loan loan = new Loan(book, user, loanDate);
        LocalDateTime replaceLoanDate = LocalDateTime.of(2025, 02, 12, 12, 12);
        loan.setLoanDate(replaceLoanDate);
        assertEquals(loan.getLoanDate(),replaceLoanDate);
    }

    /**
     * This test tests the method that gets a new Return Date on existing loan
     */
    @Test
    public void testGetReturnDate(){
        LocalDateTime loanDate = LocalDateTime.now();
        Loan loan = new Loan(book, user, loanDate);
        LocalDateTime returnDate = LocalDateTime.of(2025, 02, 12, 12, 12);
        loan.setReturnDate(returnDate);
        assertEquals(loan.getReturnDate(),returnDate);
    }

    /**
     * This test tests the method of actively returning the loan
     */
    @Test
    public void testGetStatus(){
        LocalDateTime loanDate = LocalDateTime.now();
        Loan loan = new Loan(book, user, loanDate);
        loan.setStatus(LoanStatus.ACTIVE);
        assertEquals(loan.getStatus(),LoanStatus.ACTIVE);
    }

    /**
     * This test tests the method of returning the loan in a returned manner
     */
    @Test
    public void testReturnLoan(){
        library.loanABook(user.getId(), book.getIsbn());
        Loan loan = library.loans.get(0);
        Loan returnedLoan = library.returnLoan(loan);
        assertEquals(returnedLoan.getStatus(),LoanStatus.RETURNED);
    }

    /*
     * This test tests the method returns the loan as Null when there is no loan
     */
    @Test
    public void testReturnLoadnNullLoan(){
        assertNull(library.returnLoan(null));
    }


    /*
     * This test verifies that the book returned on the loan is the correct one.
     */
    @Test
    public void testBookReturnedIsCorrect(){
        library.addBook(book2);
        library.loanABook(user.getId(), book2.getIsbn());
        Loan loan = library.loans.get(0);
        Loan returnedLoan = library.returnLoan(loan);
        assertEquals(returnedLoan.getBook(),book2);
    }

    
    /*
     * This test verifies that user that returned the book on the loan is the correct one.
     */
    @Test
    public void testBookUserthatReturnedBookIsCorrect(){
        library.addBook(book3);
        library.loanABook(user.getId(), book3.getIsbn());
        Loan loan = library.loans.get(0);
        Loan returnedLoan = library.returnLoan(loan);
        assertEquals(returnedLoan.getUser(),user);
    }
}
