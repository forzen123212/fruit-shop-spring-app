package com.example.springfirsthw.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Data
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false,unique = true)
    private String isbn;
    @Column(nullable = false)
    private BigDecimal price;
    private String description;
    private String coverImage;

    public Book() {

    }

    public Book(long id, String title, String author, String isbn,
                BigDecimal price, String description, String coverImage) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.description = description;
        this.coverImage = coverImage;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public String getAuthor() {
        return author;
    }

    @Nullable
    public String getIsbn() {
        return isbn;
    }

    @Nullable
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@Nullable BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    public void setAuthor(@Nullable String author) {
        this.author = author;
    }

    public void setIsbn(@Nullable String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book book)) {
            return false;
        }
        if (getId() != book.getId()) {
            return false;
        }
        if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) {
            return false;
        }
        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor())
                : book.getAuthor() != null) {
            return false;
        }
        if (getIsbn() != null ? !getIsbn().equals(book.getIsbn()) : book.getIsbn() != null) {
            return false;
        }
        if (getPrice() != null ? !getPrice().equals(book.getPrice()) : book.getPrice() != null) {
            return false;
        }
        if (getDescription() != null ? !getDescription().equals(book.getDescription())
                : book.getDescription() != null) {
            return false;
        }
        return getCoverImage() != null ? getCoverImage().equals(book.getCoverImage())
                : book.getCoverImage() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getIsbn() != null ? getIsbn().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getCoverImage() != null ? getCoverImage().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", author='" + author + '\''
                + ", isbn='" + isbn + '\''
                + ", price=" + price
                + ", description='" + description + '\''
                + ", coverImage='" + coverImage + '\'';
    }
}
