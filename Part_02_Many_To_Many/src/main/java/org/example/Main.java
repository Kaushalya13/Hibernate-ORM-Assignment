package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setId("B001");
        book.setName("Harry Potter");

        Book book1 = new Book();
        book1.setId("B002");
        book1.setName("Beloved");

        Author author = new Author();
        author.setId("A001");
        author.setName("J.K.Rowling");

        Author author1 = new Author();
        author1.setId("A002");
        author1.setName("Toni Morrison");

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);

        List<Author> authorList = new ArrayList<>();
        authorList.add(author);
        authorList.add(author1);

        book.setAuthors(authorList);
        book1.setAuthors(authorList);

        author.setBooks(bookList);
        author1.setBooks(bookList);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        session.persist(book1);
        session.persist(author);
        session.persist(author1);

        transaction.commit();
        session.close();
    }
}