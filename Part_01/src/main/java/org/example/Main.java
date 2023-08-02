package org.example;

import org.example.entity.Book;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setId("B001");
        book.setName("Madolduwa");

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
//        session.update(book);
//        Book book1 =session.get(Book.class,1);
//        System.out.println(book1);
        session.remove(book);

        transaction.commit();
        session.close();
    }
}