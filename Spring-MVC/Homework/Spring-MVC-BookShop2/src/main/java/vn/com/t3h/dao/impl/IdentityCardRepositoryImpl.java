package vn.com.t3h.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.IdentityCardRepository;
import vn.com.t3h.entity.IdentityCardEntity;

import java.util.List;
@Repository
public class IdentityCardRepositoryImpl implements IdentityCardRepository {
   private final SessionFactory sessionFactory;

    public IdentityCardRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public IdentityCardEntity find(String fullName, String address, String identityNumber) {
    Session session = sessionFactory.openSession();
        String hql = "FROM IdentityCardEntity WHERE fullName = :fullName AND address = :address AND identityNumber = :identityNumber";
        Query<IdentityCardEntity> query = session.createQuery(hql, IdentityCardEntity.class);
        query.setParameter("fullName", fullName);
        query.setParameter("address", address);
        query.setParameter("identityNumber", identityNumber);
        List<IdentityCardEntity> identityEntities = query.getResultList();
        session.close();
        if (identityEntities != null && identityEntities.size() > 0) {
            return identityEntities.get(0);
        }
        return null;

    }

    @Override
    public Integer save(IdentityCardEntity identityCardEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer indentityID = null;
        try {
            transaction = session.beginTransaction();

            indentityID = (Integer) session.save(identityCardEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return indentityID;
    }
}
