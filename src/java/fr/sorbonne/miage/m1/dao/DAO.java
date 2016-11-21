package fr.sorbonne.miage.m1.dao;

import java.util.List;

/**
 *
 * @author eddebbima
 */
public interface DAO<T> {
    
    public void create(T obj);
    
    public void update(T obj);
    
    public void delete (T obj);
    
    public List<T> findAll();
    
    public T findById(int id);
}
