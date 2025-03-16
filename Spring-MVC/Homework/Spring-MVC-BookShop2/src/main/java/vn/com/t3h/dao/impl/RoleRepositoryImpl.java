package vn.com.t3h.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.RoleRepository;
import vn.com.t3h.entity.RoleEntity;

import javax.transaction.Transactional;

@Repository

public class RoleRepositoryImpl implements RoleRepository {
    private final SessionFactory sessionFactory;


    public RoleRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public RoleEntity findByRoleName(String roleName) {
        Session session = sessionFactory.openSession();
        Query<RoleEntity> query = session.createQuery("from RoleEntity where role_name = :roleName");
        query.setParameter("roleName", roleName);
        return query.uniqueResult();
    }
}
