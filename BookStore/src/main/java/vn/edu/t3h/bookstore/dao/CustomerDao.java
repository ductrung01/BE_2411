package vn.edu.t3h.bookstore.dao;

import vn.edu.t3h.bookstore.model.Book;
import  java.util.List;
public interface CustomerDao {
    List<Book> findByCondition(String keyword);
}
