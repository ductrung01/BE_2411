package vn.com.t3h.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.ProductDao;
import vn.com.t3h.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Product> findAll() {
        String sql = "select * from products";

        List<Product> products = jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setBookTitle(rs.getString("book_title"));
                product.setAuthor(rs.getString("author"));
                product.setPageCount(rs.getInt("page_count"));
                product.setPublisher(rs.getString("publisher"));
                product.setPublicationYear(rs.getInt("publication_year"));
                product.setGenre(rs.getString("genre"));
                product.setPrice(rs.getDouble("price"));
                product.setDiscount(rs.getDouble("discount"));
                product.setStockQuantity(rs.getInt("stock_quantity"));
                product.setDescription(rs.getString("description"));
                return product;
            }
        });
        return products;
    }

    @Override
    public int add(Product product) {
        String sql = "INSERT INTO products (book_title, author, page_count, publisher, publication_year, genre, price, discount, stock_quantity, description, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, product.getBookTitle(), product.getAuthor(), product.getPageCount(),
                product.getPublisher(), product.getPublicationYear(), product.getGenre(),
                product.getPrice(), product.getDiscount(), product.getStockQuantity(),
                product.getDescription(), product.getImage());
    }

    @Override
    public Product getProductById(int id) {
        String sql = "SELECT p.id, p.book_title, p.author, p.page_count, p.publisher, p.publication_year, p.genre, p.price, p.discount, p.stock_quantity, p.description, p.image FROM products p WHERE id = ?";

        // queryForObject để lấy một sản phẩm duy nhất
        return jdbcTemplate.queryForObject(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setBookTitle(rs.getString("book_title"));
                product.setAuthor(rs.getString("author"));
                product.setPageCount(rs.getInt("page_count"));
                product.setPublisher(rs.getString("publisher"));
                product.setPublicationYear(rs.getInt("publication_year"));
                product.setGenre(rs.getString("genre"));
                product.setPrice(rs.getDouble("price"));
                product.setDiscount(rs.getDouble("discount"));
                product.setStockQuantity(rs.getInt("stock_quantity"));
                product.setDescription(rs.getString("description"));
                product.setImage(rs.getString("image"));
                return product;
            }
        }, id);
    }

}
