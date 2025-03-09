package vn.com.t3h.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.UserRepository;
import vn.com.t3h.entity.UserEntity;

import java.util.List;

@Repository
public class UserHibernateRepositoryImpl implements UserRepository {
    private final SessionFactory sessionFactory;

    public UserHibernateRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserEntity> getAllUser() {
        Session session = sessionFactory.openSession();
        String sql = "from UserEntity";
        Query<UserEntity> query = session.createQuery(sql, UserEntity.class);
        List<UserEntity> list = query.list();
        session.close();
        return list;


    }

    @Override
    public List<UserEntity> findByUserName(String userName, String fullName) {
        Session session = sessionFactory.openSession();
        StringBuilder sql = new StringBuilder("select u from UserEntity u join u.identityCardEntity ic where 1=1");

        if (userName != null) {
            sql.append(" and u.username =:userName");
        }
        if (fullName != null) {
            sql.append(" and ic.fullName =:fullName");
        }

        Query<UserEntity> query = session.createQuery(sql.toString(), UserEntity.class);

        if (userName != null) {
            query.setParameter("userName", userName);
        }
        if (fullName != null) {
            query.setParameter("fullName", fullName);
        }

        List<UserEntity> userEntities = query.getResultList();
        session.close();
        return userEntities;
    }

}
