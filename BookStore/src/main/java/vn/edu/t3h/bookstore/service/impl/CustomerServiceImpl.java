package vn.edu.t3h.bookstore.service.impl;

import com.mysql.cj.util.StringUtils;
import vn.edu.t3h.bookstore.dao.CustomerDao;
import vn.edu.t3h.bookstore.dao.impl.CustomerDaoImpl;
import vn.edu.t3h.bookstore.model.Book;
import vn.edu.t3h.bookstore.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;
   public CustomerServiceImpl(CustomerDao customerDao) {
       this.customerDao = customerDao;
   }
    @Override
    public List<Book> findByCondition(String keyword) {
        if(StringUtils.isNullOrEmpty(keyword)){
            keyword = null;
        }
        return customerDao.findByCondition(keyword);
    }
}
