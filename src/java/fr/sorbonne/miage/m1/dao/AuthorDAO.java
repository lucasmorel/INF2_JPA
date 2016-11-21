/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Author;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class AuthorDAO implements DAO<Author>{

    EntityManagerFactory emf =
Persistence.createEntityManagerFactory("INF2_JPAPU");
EntityManager em = emf.createEntityManager();
    
    @Override
    public void create(Author obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public void update(Author obj) {
        em.getTransaction().begin();
        em.refresh(obj);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Author obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    @Override
    public List<Author> findAll() {
        em.getTransaction().begin();
        List<Author> ret = em.createQuery("Select b FROM Author b").getResultList();
        return ret;
    }

    @Override
    public Author findById(int id) {
        em.getTransaction().begin();
        Author b =  em.find(Author.class, id);
        return b;
    }
   
}
