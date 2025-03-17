package vn.com.t3h.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.UserRepository;
import vn.com.t3h.entity.UserEntity;

import java.util.ArrayList;
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
        List<UserEntity> list = new ArrayList<>();

        try {
            String hql = "FROM UserEntity u " +
                    "LEFT JOIN FETCH u.identityCardEntity ic " +
                    "LEFT JOIN FETCH u.roles r";

            Query<UserEntity> query = session.createQuery(hql, UserEntity.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }

    @Override
    public List<UserEntity> findByUserName(String userName, String fullName, String identityNumber) {
        Session session = sessionFactory.openSession();
        StringBuilder hql = new StringBuilder("SELECT u FROM UserEntity u " +
                "LEFT JOIN FETCH u.identityCardEntity ic " +
                "LEFT JOIN FETCH u.roles r ");

        boolean hasWhereClause = false;
        if ((userName != null && !userName.isEmpty()) ||
                (fullName != null && !fullName.isEmpty()) ||
                (identityNumber != null && !identityNumber.isEmpty())) {
            hql.append("WHERE ");
            hasWhereClause = true;
        }

        if (userName != null && !userName.isEmpty()) {
            hql.append("u.username = :userName ");
            if ((fullName != null && !fullName.isEmpty()) || (identityNumber != null && !identityNumber.isEmpty())) {
                hql.append("OR ");
            }
        }
        if (fullName != null && !fullName.isEmpty()) {
            hql.append("ic.fullName = :fullName ");
            if (identityNumber != null && !identityNumber.isEmpty()) {
                hql.append("OR ");
            }
        }
        if (identityNumber != null && !identityNumber.isEmpty()) {
            hql.append("ic.identityNumber = :identityNumber ");
        }

        Query<UserEntity> query = session.createQuery(hql.toString(), UserEntity.class);

        if (userName != null && !userName.isEmpty()) {
            query.setParameter("userName", userName);
        }
        if (fullName != null && !fullName.isEmpty()) {
            query.setParameter("fullName", fullName);
        }
        if (identityNumber != null && !identityNumber.isEmpty()) {
            query.setParameter("identityNumber", identityNumber);
        }

        List<UserEntity> userEntities = query.getResultList();
        session.close();
        return userEntities;
    }

    @Override
    public Long saveUser(UserEntity user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Long userID = null;
        try {
            transaction = session.beginTransaction();
            userID = (long) session.save(user);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userID;
    }

    @Override
    public UserEntity findById(Long id) {
        if (id == null) {
            return null;
        }
        Session session = sessionFactory.openSession();
        UserEntity user = session.get(UserEntity.class, id);
        session.close();
        return user;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Long userID = null;
        try{
            transaction = session.beginTransaction();
            UserEntity user = session.get(UserEntity.class, id);
            if (user != null) {
                session.delete(user);
            }

            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
        finally {
            session.close();
        }

    }
}
