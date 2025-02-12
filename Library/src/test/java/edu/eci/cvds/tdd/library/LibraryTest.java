package edu.eci.cvds.tdd.library;


import edu.eci.cvds.tdd.library.Library;
import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import java.time.LocalDateTime;

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
        library3.addUser(user);
        assertNotNull(library3.loanABook(user.getId(),book3.getIsbn()));

    }

    

    @Test
    public void testLoanBookNotAvailable(){
        Library library4 = new Library();
        Book book4 = new Book("Prueba", "Ivan", "5678");
        User user = new User("Ivan","897");
        assertNull(library4.loanABook(user.getId(),book4.getIsbn()));
    }




    //TEST METODO FALTANTE

    @Test 
    public void testGetBook(){
        Library library3 = new Library();
        Book book3 = new Book("Prueba2", "Camilo", "124");
        Book book4 = new Book("Prueba4", "Camilo", "125");
        library3.addBook(book3);
        library3.addBook(book4);
        User user = new User("Camilo","12345");
        library3.addUser(user);
        assertEquals(library3.loanABook(user.getId(),book3.getIsbn()).getBook(),book3);

    }

    @Test 
    public void testGetUser(){
        Library library3 = new Library();
        Book book3 = new Book("Prueba2", "Camilo", "124");
        library3.addBook(book3);
        User user = new User("Camilo","12345");
        library3.addUser(user);
        assertEquals(library3.loanABook(user.getId(),book3.getIsbn()).getUser(),user);

    }

    @Test 
    public void testGetLoanDate(){
        Library library3 = new Library();
        Book book3 = new Book("Prueba2", "Camilo", "124");
        library3.addBook(book3);
        User user = new User("Camilo","12345");
        library3.addUser(user);
        assertNotNull(library3.loanABook(user.getId(),book3.getIsbn()).getLoanDate());

    }


    @Test 
    public void testUserSetName(){
        User user = new User("Camilo","12345");
        user.setName("Ivan");
        assertEquals(user.getName(),"Ivan");
    }


    @Test 
    public void testUserSetId(){
        User user = new User("Camilo","12345");
        user.setId("1");
        assertEquals(user.getId(),"1");
    }

    @Test 
    public void testGetNameUser(){
        User user = new User("Camilo","12345");
        assertEquals(user.getName(),"Camilo");
    }



    @Test 
    public void testGetTittle(){
        Book book3 = new Book("Prueba2", "Camilo", "124");
        assertEquals(book3.getTittle(),"Prueba2");
    }

    @Test 
    public void testAuthorTittle(){
        Book book3 = new Book("Prueba2", "Camilo", "124");
        assertEquals(book3.getAuthor(),"Camilo");
    }






    



    
    
}
