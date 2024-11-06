/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecture5.jpa.without_controllers;

import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lecture5.jpa.entities.Book;
import lecture5.jpa.entities.Magazine;
import lecture5.jpa.entities.Publication;

/**
 *
 * @author fcarella
 */
public class App {

    void run() {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("DEFAULT_PU");
            em = emf.createEntityManager();
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Entity Manager created (" + emf + ")");
            em.getTransaction().begin();

            Book book = new Book();
            book.setAuthor("Author");
            book.setPrice(29.99d);
            book.setTitle("Book Title");
            em.persist(book);

            Magazine magazine = new Magazine();
            long millis = System.currentTimeMillis();
            magazine.setCurrIssue(new java.sql.Date(millis));
            magazine.setPrice(29.99d);
            magazine.setTitle("Magazine Title");
            em.persist(magazine);

            em.getTransaction().commit();
            List<Book> ListOfBooks = em.createQuery("SELECT c FROM Book c").getResultList();
            System.out.println("----------------------------");
            System.out.println("List of Books");
            System.out.println("----------------------------");
            for (Book c : ListOfBooks) {
                System.out.println("Title: " + c.getTitle() + " Author:" + c.getAuthor());
            }
            List<Magazine> ListOfMagazines = em.createQuery("SELECT c FROM Magazine c").getResultList();
            System.out.println("----------------------------");
            System.out.println("List of Magazines");
            System.out.println("----------------------------");
            for (Magazine c : ListOfMagazines) {
                System.out.println("Title: " + c.getTitle() + " Current Issue:" + c.getCurrIssue());
            }
            List<Publication> ListOfPublications = em.createQuery("SELECT c FROM Publication c").getResultList();
            System.out.println("----------------------------");
            System.out.println("List of Publications");
            System.out.println("----------------------------");
            for (Publication c : ListOfPublications) {
                System.out.println("Title: " + c.getTitle());
            }

        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (emf != null) {
                emf.close();
            }
//            if(em!=null)
//                em.close();
        }
    }

}
