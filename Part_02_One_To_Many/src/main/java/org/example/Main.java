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
        book1.setName("The Crimes of Grindelwald");

        Author author = new Author();
        author.setId("A001");
        author.setName("J.K.Rowling");

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);

        author.setBookList(bookList);
        book.setAuthor(author);
        book1.setAuthor(author);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        session.persist(book1);
        session.persist(author);

        transaction.commit();
        session.close();
    }
}