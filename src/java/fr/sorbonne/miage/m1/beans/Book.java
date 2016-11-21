package fr.sorbonne.miage.m1.beans;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name="book")
public class Book implements Serializable {
    @Id
    @Column(nullable = false, length = 10)
    private Integer isbn;
    
    @Column(nullable = false, length = 255)
    private String title;
    
    @Column(nullable = false, length = 3, precision = 2)
    private Float price;
    
    
    @ManyToMany
    @JoinTable(name="Compo_Author_Book",
            joinColumns = @JoinColumn(name="BOOK_isbn"))
    private Collection<Author> auteurs;
    
    public Book(Integer isin, String title, Float price) {
        this.isbn = isin;
        this.title = title;
        this.price = price;
    }
    
    public Book(){};

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }
}
