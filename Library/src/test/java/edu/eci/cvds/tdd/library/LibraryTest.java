package edu.eci.cvds.tdd.library;


import edu.eci.cvds.tdd.library.Library;
import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest{

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Prueba", "Ivan", "123");
        assertTrue(library.addBook(book));
    }
    
    
}
