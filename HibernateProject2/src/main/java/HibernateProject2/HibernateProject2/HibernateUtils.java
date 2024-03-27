package HibernateProject2.HibernateProject2;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import entity.Actor;
import entity.Film;
import entity.FilmCategory;
import entity.Person;

public class HibernateUtils {
	
	 public static SessionFactory getSessionFactory(){
	        Configuration configuration = new Configuration();
	        SessionFactory sessionFactory = null;

	        Properties settings = new Properties();
	        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/Film");
	        settings.put(Environment.USER, "root");
	        settings.put(Environment.PASS, "Password@02");
	        settings.put(Environment.SHOW_SQL, "true");
	        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	        settings.put(Environment.HBM2DDL_AUTO, "create-drop");

	        configuration.setProperties(settings);
	        configuration.addAnnotatedClass(Person.class);
	        configuration.addAnnotatedClass(Actor.class);
	        configuration.addAnnotatedClass(Film.class);
	        configuration.addAnnotatedClass(FilmCategory.class);

	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties()).build();

	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	        return sessionFactory;
	    }

}
