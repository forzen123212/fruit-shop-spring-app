package com.example.springfirsthw.repositories;

import com.example.springfirsthw.domain.Book;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BookRepositoryImpl implements BookRepository {
    private static final String CANNOT_SAVE_BOOK_TO_DB_MSG =
            "Cannot save book to database: ";
    private static final String FAILED_TO_GET_ALL_BOOKS_FROM_DB_MSG =
            "Failed to get all the books from DB!";
    private static final String FAILED_TO_FIND_BOOK_BY_ID =
            "Failed to find book by id in DB: ";

    private final SessionFactory factory;

    @Override
    public List<Book> findAll() {
        try (Session session = factory.openSession()) {
            Query<Book> booksFromDb = session.createQuery("FROM Book b", Book.class);
            return booksFromDb.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(FAILED_TO_GET_ALL_BOOKS_FROM_DB_MSG);
        }
    }

    @Override
    public Book save(Book book) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(CANNOT_SAVE_BOOK_TO_DB_MSG + book);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return book;
    }

    @Override
    public Optional<Book> findById(Long id) {
        try (Session session = factory.openSession()) {
            return Optional.ofNullable(session.get(Book.class, id));
        } catch (Exception e) {
            throw new RuntimeException(
                    FAILED_TO_FIND_BOOK_BY_ID + id);
        }
    }
}
