package vn.edu.t3h.bookstore.dao.impl;

import vn.edu.t3h.bookstore.dao.BookDao;
import vn.edu.t3h.bookstore.model.Book;
import vn.edu.t3h.bookstore.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> getAllBooks() {
        Connection connection = null;
        List<Book> books = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT id, name, price, discount, author, publisher, yearPublishing, pages, quantity, totalBuy, description, imageName FROM product;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setIdSach(resultSet.getInt("id"));
                book.setTenSach(resultSet.getString("name"));
                book.setGia(resultSet.getDouble("price"));
                book.setGiamGia(resultSet.getDouble("discount"));
                book.setTacGia(resultSet.getString("author"));
                book.setNhaXuatBan(resultSet.getString("publisher"));
                book.setNamXuatBan(resultSet.getInt("yearPublishing"));
                book.setSoTrang(resultSet.getInt("pages"));
                book.setSoLuongTonKho(resultSet.getInt("quantity"));
                book.setTongSoLuotMua(resultSet.getInt("totalBuy"));
                book.setMoTa(resultSet.getString("description"));
                book.setHinhAnh(resultSet.getString("imageName"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }


        return books;
    }

    @Override
    public int addBook(Book book) {
        int rows = 0;
        String sql = "INSERT INTO product (name, author, pages, publisher, yearPublishing, price, discount, quantity, description, imageName, totalBuy, createdAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            if (connection == null) {
                System.out.println("Connection is null!");
                return rows;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTenSach());
            preparedStatement.setString(2, book.getTacGia());
            preparedStatement.setInt(3, book.getSoTrang());
            preparedStatement.setString(4, book.getNhaXuatBan());
            preparedStatement.setInt(5, book.getNamXuatBan());
            preparedStatement.setDouble(6, book.getGia());
            preparedStatement.setDouble(7, book.getGiamGia());
            preparedStatement.setInt(8, book.getSoLuongTonKho());
            preparedStatement.setString(9, book.getMoTa());
            preparedStatement.setString(10, book.getHinhAnh());
            preparedStatement.setInt(11, book.getSoLuongTonKho());
            preparedStatement.setTimestamp(12, new java.sql.Timestamp(System.currentTimeMillis())); // Thêm giá trị cho createdAt

            rows = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return rows;
    }

    @Override
    public int deleteBookById(int id) {
        int rows = 0;
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();

            connection.setAutoCommit(false);

            String deleteCategoryQuery = "DELETE FROM product_category WHERE productId = ?";
            try (PreparedStatement categoryStatement = connection.prepareStatement(deleteCategoryQuery)) {
                categoryStatement.setInt(1, id);
                categoryStatement.executeUpdate();
            }

            String deleteWishlistQuery = "DELETE FROM wishlist_item WHERE productId = ?";
            try (PreparedStatement wishlistStatement = connection.prepareStatement(deleteWishlistQuery)) {
                wishlistStatement.setInt(1, id);
                wishlistStatement.executeUpdate();
            }

            String deleteReviewQuery = "DELETE FROM product_review WHERE productId = ?";
            try (PreparedStatement reviewStatement = connection.prepareStatement(deleteReviewQuery)) {
                reviewStatement.setInt(1, id);
                reviewStatement.executeUpdate();
            }

            String deleteCartItemQuery = "DELETE FROM cart_item WHERE productId = ?";
            try (PreparedStatement cartItemStatement = connection.prepareStatement(deleteCartItemQuery)) {
                cartItemStatement.setInt(1, id);
                cartItemStatement.executeUpdate();
            }

            String deleteOrderItemQuery = "DELETE FROM order_item WHERE productId = ?";
            try (PreparedStatement orderItemStatement = connection.prepareStatement(deleteOrderItemQuery)) {
                orderItemStatement.setInt(1, id);
                orderItemStatement.executeUpdate();
            }

            String deleteProductQuery = "DELETE FROM product WHERE id = ?";
            try (PreparedStatement productStatement = connection.prepareStatement(deleteProductQuery)) {
                productStatement.setInt(1, id);
                rows = productStatement.executeUpdate();
            }

            connection.commit();
        } catch (Exception e) {

            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return rows;
    }


    @Override
    public Book getBookById(int id) {
        Book book = null;
        String sql ="SELECT p.id,p.name,p.author,p.pages, p.publisher,p.yearPublishing,p.price,p.discount,p.quantity,p.description,p.imageName,p.totalBuy" +
                "  FROM product p WHERE id = ?";
        Connection connection = null;
        try{
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 book = new Book();
                 book.setIdSach(resultSet.getInt("id"));
                 book.setTenSach(resultSet.getString("name"));
                 book.setGia(resultSet.getDouble("price"));
                 book.setGiamGia(resultSet.getDouble("discount"));
                 book.setTacGia(resultSet.getString("author"));
                 book.setNhaXuatBan(resultSet.getString("publisher"));
                 book.setNamXuatBan(resultSet.getInt("yearPublishing"));
                 book.setSoTrang(resultSet.getInt("pages"));
                 book.setSoLuongTonKho(resultSet.getInt("quantity"));
                 book.setTongSoLuotMua(resultSet.getInt("totalBuy"));
                 book.setMoTa(resultSet.getString("description"));
                 book.setHinhAnh(resultSet.getString("imageName"));




            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return book;

    }

    @Override
    public int updateBook(Book book) {
        int rows = 0;
        String query = "UPDATE product SET name = ?, price = ?,discount = ?, author = ?,publisher = ?,yearPublishing = ?, pages = ?, quantity = ?,totalBuy = ?, description = ?, imageName = ? " +
                "WHERE id = ?";
        Connection connection = null;
        try{
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, book.getTenSach());
            preparedStatement.setDouble(2, book.getGia());
            preparedStatement.setDouble(3, book.getGiamGia());
            preparedStatement.setString(4,book.getTacGia());
            preparedStatement.setString(5, book.getNhaXuatBan());
            preparedStatement.setInt(6, book.getNamXuatBan());
            preparedStatement.setInt(7, book.getSoTrang());
            preparedStatement.setInt(8, book.getSoLuongTonKho());
            preparedStatement.setDouble(9,book.getTongSoLuotMua());
            preparedStatement.setString(10, book.getMoTa());
            preparedStatement.setString(11, book.getHinhAnh());
            preparedStatement.setInt(12,book.getIdSach());
            rows = preparedStatement.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
        return rows;
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
