package org.example;

import org.example.entity.Book;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Create new object in book type
        Book book = new Book();
        book.setId("B001");
        book.setName("Madolduwa");

        Book book1 = new Book();
        book1.setId("B002");
        book1.setName("Harry Potter");

        Book book2 = new Book();
        book2.setId("B003");
        book2.setName("The Sea");

        //Get the Hibernate session instance from the factory configuration
        Session session = FactoryConfiguration.getInstance().getSession();

        //Begin a new transaction
        Transaction transaction = session.beginTransaction();

        //save the book object to the database
        session.persist(book);
        session.persist(book1);
        session.persist(book2);

        //Commit the transaction to make the changes permanent in the database
        transaction.commit();
        session.close();
        update();
        searchId();
        Delete();
    }

    //update the book object to the database
    public static void update(){

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Book book =session.load(Book.class,"B003");
        book.setName("Harry Potter");
        session.update(book);
        System.out.println(book);
        transaction.commit();
        session.close();
    }

    //Delete the book object to the database
    public static void Delete(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Book Id : ");
        String isDatele = scanner.nextLine();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Book book = session.get(Book.class,isDatele);
        session.remove(book);
        System.out.println(book);
        transaction.commit();
        session.close();
    }

    //Search the book object to the database
    public static void searchId(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your Book ID :");
        String isSearch = scanner.nextLine();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Book book = session.get(Book.class,isSearch);
        System.out.println(book.toString());
        transaction.commit();
        session.close();
    }
}