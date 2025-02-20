package vn.edu.t3h.bookstore.dao.impl;

import vn.edu.t3h.bookstore.dao.CustomerDao;
import vn.edu.t3h.bookstore.model.Book;
import vn.edu.t3h.bookstore.service.CustomerService;
import vn.edu.t3h.bookstore.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public List<Book> findByCondition(String keyword) {
        String sql = "SELECT p.name, p.imageName, p.price FROM product p WHERE p.name LIKE ?";

        List<Book> bookResult = new ArrayList<>();
        Connection connection = null;
        try{
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if(keyword != null){
                preparedStatement.setString(1,"%"+keyword+"%");

            }else {
                preparedStatement.setNull(1, Types.VARCHAR);

            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Book book = new Book();
                book.setTenSach(resultSet.getString("name"));
                book.setHinhAnh(resultSet.getString("imageName"));
                book.setGia(resultSet.getDouble("price"));
                bookResult.add(book);


            }


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return bookResult;
    }
    private static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
