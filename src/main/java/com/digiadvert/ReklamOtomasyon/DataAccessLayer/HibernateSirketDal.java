package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Sirket;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class HibernateSirketDal implements ISirketDal {
    private EntityManager entityManager;
    @Autowired
    public HibernateSirketDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Sirket> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Sirket> sirkets = session.createQuery("from Sirket",Sirket.class).getResultList();
        return sirkets;
    }

    @Override
    @Transactional
    public void add(Sirket sirket) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(sirket);

    }

    @Override
    @Transactional
    public void update(Sirket sirket) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(sirket);

    }

    @Override
    @Transactional
    public void delete(Sirket sirket) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(sirket);

    }

    @Override
    @Transactional
    public Sirket getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Sirket sirket = session.get(Sirket.class,id);
        return sirket;
    }
}
