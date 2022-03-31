package com.beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class DAO {
    static Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Library library = new Library();
    Books books = new Books();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void insertRecord() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        library.setLib_id(Integer.parseInt(bufferedReader.readLine()));
        library.setNo_of_books(Integer.parseInt(bufferedReader.readLine()));

        books.setBook_id(Integer.parseInt(bufferedReader.readLine()));
        books.setBook_name(bufferedReader.readLine());
        books.setSalary(Integer.parseInt(bufferedReader.readLine()));
        books.setPublisher(bufferedReader.readLine());

        Set<Books> booksSet = new HashSet<>();
        booksSet.add(books);
        library.setBooks(booksSet);

        session.save(library);
        transaction.commit();
    }
}
