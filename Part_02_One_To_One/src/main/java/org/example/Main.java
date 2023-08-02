package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {
        Author author = new Author();
        author.setId("A001");
        author.setName("J.K.Rowling");

        Book book = new Book();
        book.setId("B001");
        book.setName("Harry Potter");
        book.setAuthor(author);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        session.persist(author);

        transaction.commit();
        session.close();
    }
}