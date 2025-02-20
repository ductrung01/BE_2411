package vn.edu.t3h.bookstore.service;

import vn.edu.t3h.bookstore.model.Book;
import java.util.List;
public interface BookService {
    List<Book> getAllBook();
    int addBook(Book book);
    int deleteBookById(int id);
    Book getBookById(int id);
    int updateBook(Book book);
}
