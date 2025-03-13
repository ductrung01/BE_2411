package vn.com.t3h.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public List<UserEntity> findByUserName(String userName, String fullName ,String identityNumber) {
        Session session = sessionFactory.openSession();
        StringBuilder hql = new StringBuilder("SELECT u " +
                "FROM UserEntity u " +
                "JOIN u.identityCardEntity ic " +
                "JOIN u.roles r " +
                "WHERE 1=1");
       if(userName != null && !userName.equals("")) {
           hql.append(" and u.userName=:userName ");
       }
       if(fullName != null && !fullName.equals("")) {
           hql.append(" and u.fullName=:fullName ");
       }
       if(identityNumber != null && !identityNumber.equals("")) {
           hql.append(" and u.identityNumber=:identityNumber ");
       }

       Query<UserEntity> query = session.createQuery(hql.toString(),UserEntity.class);
       if(userName != null && !userName.equals("")) {
           query.setParameter("userName", userName);
       }
       if(fullName != null && !fullName.equals("")) {
           query.setParameter("fullName", fullName);
       }
       if(identityNumber != null && !identityNumber.equals("")) {
           query.setParameter("identityNumber", identityNumber);
       }
       List<UserEntity> userEntities = query.getResultList();
       session.close();
       return userEntities;

    }

}
