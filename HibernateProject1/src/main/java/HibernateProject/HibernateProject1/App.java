package HibernateProject.HibernateProject1;

/**
 * Hello world!
 *
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Organization" );

        Employee employee1 = new Employee();
        employee1.setEmpName("Simran Kaur");
        employee1.setEmpEmail("simran292002@gmail.com");
        Employee employee2=new Employee();
        employee2.setEmpName("Kashish");
        employee2.setEmpEmail("kashish@gmail.com");
        Employee employee3=new Employee();
        employee3.setEmpName("Mansi");
        employee3.setEmpEmail("mansi@gmail.com");
        Employee employee4=new Employee();
        employee4.setEmpName("Anirudh");
        employee4.setEmpEmail("anirudh@gmail.com");
        Employee employee5=new Employee();
        employee5.setEmpName("Pushkar");
        employee5.setEmpEmail("pushkar@gmail.com");
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        //create and insert
        session.beginTransaction();
        session.persist(employee1);
        session.persist(employee2);
        session.persist(employee3);
        session.persist(employee4);
        session.persist(employee5);
        session.getTransaction().commit();
        System.out.println("Inital database entries");
        session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
        
        //update
        employee2.setEmpName("Kavya");
        employee2.setEmpEmail("kavya@gmail.com");
		
        session.beginTransaction();
		session.merge(employee2);
		System.out.println("Database entries after updation");
	    session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
	    session.getTransaction().commit();
		
		//remove
		session.remove(employee2);
		session.beginTransaction();
		System.out.println("Database entries after deletion");
		session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
		session.getTransaction().commit();
		 
		//closing the session
        session.close();
    }
}
