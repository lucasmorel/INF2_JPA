/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class BookDAO implements DAO<Book>{

    EntityManagerFactory emf =
Persistence.createEntityManagerFactory("INF2_JPAPU");
EntityManager em = emf.createEntityManager();   
    
    @Override
    public void create(Book obj) {
        em.persist(obj);
    }

    @Override
    public void update(Book obj) {
        em.refresh(obj);
    }

    @Override
    public void delete(Book obj) {
        em.remove(obj);
    }

    @Override
    public List<Book> findAll() {
        List<Book> ret = em.createQuery("Select b FROM Book b").getResultList();
        return ret;
    }

    @Override
    public Book findById(int id) {
        Book b =  em.find(Book.class, id);
        return b;
    }
   
}
