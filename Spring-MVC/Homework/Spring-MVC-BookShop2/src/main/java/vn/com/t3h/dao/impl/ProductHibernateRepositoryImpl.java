package vn.com.t3h.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory; // Sử dụng SessionFactory của Hibernate
import org.hibernate.Transaction;
import org.springframework.util.StringUtils;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.ProductRepository;
import vn.com.t3h.entity.ProductEntity;

import java.util.List;

@Repository("productHibernateRepositoryImpl")
public class ProductHibernateRepositoryImpl implements ProductRepository {
    private final SessionFactory sessionFactory;
    public ProductHibernateRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<ProductEntity> findAll() {
        Session session = sessionFactory.openSession();
//        session.beginTransaction();
        String hql = "from ProductEntity";
        Query query = session.createQuery(hql,ProductEntity.class);
        List<ProductEntity> productEntities = query.getResultList();

        session.close();
        return productEntities;


    }

    @Override
    public List<ProductEntity> findByCondition(Double price, String bookTitle, String publisher, String categoryName) {
        Session session = sessionFactory.openSession();
        StringBuilder hql = new StringBuilder("select p from ProductEntity p  join p.category c where 1=1");
        if (price != null) {
            hql.append(" and p.price = :price" );
        }
        if (StringUtils.hasText(bookTitle)) {
            hql.append(" and p.bookTitle = :bookTitle");
        }
        if(StringUtils.hasText(publisher)) {
            hql.append(" and p.publisher =:publisher");
        }
        if(StringUtils.hasText(categoryName)) {
            hql.append(" and c.name =:categoryName");
        }
        Query<ProductEntity> query = session.createQuery(hql.toString(),ProductEntity.class);
        if(price != null) {
            query.setParameter("price", price);
        }
        if(StringUtils.hasText(bookTitle)) {
            query.setParameter("bookTitle", bookTitle);
        }
        if(StringUtils.hasText(publisher)) {
            query.setParameter("publisher", publisher);
        }
        if(StringUtils.hasText(categoryName)) {
            query.setParameter("categoryName", categoryName);
        }
        List<ProductEntity> productEntities = query.getResultList();
        session.close();
        return productEntities;





    }
}
