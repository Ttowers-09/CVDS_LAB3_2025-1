package edu.eci.cvds.tdd.library;


import edu.eci.cvds.tdd.library.Library;
import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import edu.eci.cvds.tdd.library.loan.LoanStatus;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

public class LibraryTest{

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Prueba", "Ivan", "123");
        assertTrue(library.addBook(book));
    }

    @Test
    public void testAddCorrectAmount(){
        Library library2 = new Library();
        Book book2 = new Book("Prueba2", "Camilo", "124");
        library2.addBook(book2);
        library2.addBook(book2);
        assertTrue(library2.books.get(book2)==2);
    }

    @Test 
    public void testSuccesfullLoan(){
        Library library3 = new Library();
        Book book3 = new Book("Prueba2", "Camilo", "124");
        library3.addBook(book3);
        User user = new User("Camilo","12345");
        assertNotNull(library3.loanABook(user.getId(),book3.getIsbn()));

    }

    @Test
    public void testLoanBookNotAvailable(){
        Library library4 = new Library();
        Book book4 = new Book("Prueba", "Ivan", "5678");
        User user = new User("Ivan","897");
        assertNull(library4.loanABook(user.getId(),book4.getIsbn()));
    }
    



    
    
}
