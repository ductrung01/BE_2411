package vn.edu.t3h.bookstore.dao;

import vn.edu.t3h.bookstore.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
    int addBook(Book book);
    int deleteBookById(int id);
    Book getBookById(int id);
    int updateBook(Book book);
}
