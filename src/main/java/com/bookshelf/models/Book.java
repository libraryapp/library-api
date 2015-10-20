package com.bookshelf.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
@NamedQueries({
        @NamedQuery(
                name = "com.bookshelf.models.Book.findAll",
                query = "SELECT p FROM Book p"
        )
})

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "authorFirst", nullable = false)
    private String authorFirst;

    @Column(name = "authorLast", nullable = false)
    private String authorLast;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    public Book(){
    }

    public Book(String title, String authorFirst, String authorLast, String isbn){
        title = this.title;
        authorFirst = this.authorFirst;
        authorLast = this.authorLast;
        isbn = this.isbn;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirst() {
        return authorFirst;
    }

    public void setAuthorFirst(String authorFirst) {
        this.authorFirst = authorFirst;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthorLast() {
        return authorLast;
    }

    public void setAuthorLast(String authorLast) {
        this.authorLast = authorLast;
    }
}
