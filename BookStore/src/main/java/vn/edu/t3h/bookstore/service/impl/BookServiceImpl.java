package vn.edu.t3h.bookstore.service.impl;

import vn.edu.t3h.bookstore.dao.BookDao;
import vn.edu.t3h.bookstore.model.Book;
import vn.edu.t3h.bookstore.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    @Override
    public List<Book> getAllBook() {
      return bookDao.getAllBooks();
    }

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }
}
