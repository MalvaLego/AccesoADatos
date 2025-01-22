package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        createSesion();
    }

    private static void createSesion() {

        SessionFactory sessionFactory=
                new Configuration().configure().buildSessionFactory();
        Session session= sessionFactory.openSession();

        if (session!=null){
            System.out.println("Session initiated");
        }else{
            System.out.println("Error on creating session");
        }

        if (session!=null){
            sessionFactory.close();
        }
        System.out.println("Session has been closed");

    }
}
