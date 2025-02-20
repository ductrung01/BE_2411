package vn.edu.t3h.bookstore.service;

import vn.edu.t3h.bookstore.model.Book;
import  java.util.List;
public interface CustomerService {
    List<Book> findByCondition(String keyword);

}
