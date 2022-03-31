package com.beans;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        do {

            System.out.println("Enter choice \n1.Insert\n2.Update\n3.Delete\n4.Fetch\n5.FetchByCriteria\n6.FetchByProjection\n7.Exit");
            int choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice)
            {
                case 1:
                    Session session = sessionFactory.openSession();
                    Transaction transaction = session.beginTransaction();
                    Library library = new Library();


                    System.out.println("Enter library id and no of books");
                    library.setLib_id(Integer.parseInt(bufferedReader.readLine()));
                    library.setNo_of_books(Integer.parseInt(bufferedReader.readLine()));
                    Set<Books> booksSet = new HashSet<>();
                    System.out.println("Enter number of books to be entered");
                    int count = Integer.parseInt(bufferedReader.readLine());
                    for (int i=0;i<count;i++)
                    {
                        Books book = new Books();
                        book.setBook_id(Integer.parseInt(bufferedReader.readLine()));
                        book.setBook_name(bufferedReader.readLine());
                        book.setSalary(Integer.parseInt(bufferedReader.readLine()));
                        book.setPublisher(bufferedReader.readLine());
                        booksSet.add(book);
                    }

                    library.setBooks(booksSet);
                    session.save(library);
                    transaction.commit();
                    break;

                case 2:
                    session = sessionFactory.openSession();
                    transaction = session.beginTransaction();
                    System.out.println("Enter id and price");
                    int id = Integer.parseInt(bufferedReader.readLine());
                    int salary = Integer.parseInt(bufferedReader.readLine());

                    Query query = session.createQuery("update Books set salary=:x where book_id=:y");
                    query.setParameter("x",salary);
                    query.setParameter("y",id);
                    query.executeUpdate();
                    transaction.commit();
                    break;
                case 3:
                    session = sessionFactory.openSession();
                    transaction = session.beginTransaction();
                    System.out.println("Enter id and price");
                    id = Integer.parseInt(bufferedReader.readLine());
                    query = session.createQuery("delete Books where book_id=:y");
                    query.setParameter("y",id);
                    query.executeUpdate();
                    transaction.commit();
                    break;

                case 4:
                    session = sessionFactory.openSession();
                    query = session.createQuery("from Books");
                    List<Books> list1 = query.getResultList();
                    System.out.println("*****BOOKS*********");
                    for (Books  l :list1)
                    {
                        System.out.println(l);
                    }

                    query = session.createQuery("from Library");
                    List<Library> list5= query.getResultList();
                    System.out.println("******* LIBRARY *******");
                    for (Library l :list5)
                    {
                        System.out.println(l);
                    }
                    break;
                case 5:
                    session = sessionFactory.openSession();
                    transaction = session.beginTransaction();

                    Criteria criteria = session.createCriteria(Books.class);
                    criteria.add(Restrictions.gt("salary",400));
                    List<Books> list = criteria.list();
                    System.out.println("*****BOOKS*********");
                    for (Books l : list)
                    {
                        System.out.println(l);
                    }
                    break;
                case 6:
                    session = sessionFactory.openSession();
                    System.out.println("Enter para1 and para2");
                    String pn = bufferedReader.readLine();
                    String pn1 = bufferedReader.readLine();
                    Criteria criteria1 = session.createCriteria(Books.class);
                    ProjectionList projectionList = Projections.projectionList();
                    projectionList.add(Projections.property(pn));
                    projectionList.add(Projections.property(pn1));
                    criteria1.setProjection(projectionList);
                    List list2 = criteria1.list();

                    Iterator it=list2.iterator();

                    while(it.hasNext())
                    {
                        Object ob[] = (Object[])it.next();
                        System.out.println(ob[0]+"--------"+ob[1]);
                    }

                case 7:
                    System.exit(0);
                    break;
            }
        }while (true);

    }
}
