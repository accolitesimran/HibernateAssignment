package HibernateProject2.HibernateProject2;



import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Actor;
import entity.Film;
import entity.FilmCategory;
import entity.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //adding records in person table
        Person p1 = new Person();
        p1.setName("Simran Kaur");
        p1.setEmail("simran292002@gmail.com");
        p1.setAddress("Kanpur");
        p1.setAadharNo("101");
        Person p2 = new Person();
        p2.setName("Kashish Khurrana");
        p2.setEmail("kashish@gmail.com");
        p2.setAddress("Kanpur");
        p2.setAadharNo("102");
        Person p3 = new Person();
        p3.setName("Manya Tripathi");
        p3.setEmail("manya@gmail.com");
        p3.setAddress("Jaipur");
        p3.setAadharNo("103");
        
        
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        session.persist(p1);
        session.persist(p2);
        session.persist(p3);
        session.getTransaction().commit();
        System.out.println("Inital database entries in person table");
        session.createQuery("from Person", Person.class).list().forEach(System.out::println);
        
        //adding records in actor table
        Actor a1=new Actor();
        a1.setName("Manya Tripathi");
        a1.setPersonId(p3);
        Actor a2=new Actor();
        a2.setName("Kashish Khurrana");
        a2.setPersonId(p2);
        session.beginTransaction();
        session.persist(a1);
        session.persist(a2);
        session.getTransaction().commit();
        System.out.println("Initial database entries in actor table");
        session.createQuery("from Actor", Actor.class).list().forEach(System.out::println);
        
       
        
        
        //adding records in film table
        Film f1=new Film();
        f1.setFilmReleaseDate("12/12/24");
        f1.setFilmTitle("film1");
        Film f2=new Film();
        f2.setFilmTitle("film2");
        f2.setFilmReleaseDate("30/03/24");
        
        //adding films in actor table
        a1.getFilms().add(f1);
        a1.getFilms().add(f2);
        
        //adding actors in film table
        f1.getActors().add(a1);
        f2.getActors().add(a1);
        
        
        session.beginTransaction();
        session.persist(f1);
        session.persist(f2);
        session.getTransaction().commit();
        System.out.println("Initial database entries in film table");
        session.createQuery("from Film",Film.class).list().forEach(System.out::println);
        
        
        //adding records to category table
        FilmCategory c1=new FilmCategory();
        c1.setCategoryName("category1");
        
        
        //adding films to a category
        c1.getFilms().add(f1);
        f1.setCategory(c1);
        f2.setCategory(c1);
        session.beginTransaction();
        session.persist(c1);
        session.getTransaction().commit();
        System.out.println("Inital database entries in category table");
        session.createQuery("from FilmCategory",FilmCategory.class).list().forEach(System.out::println);
        
        
        session.close();
        
        
    }
}
