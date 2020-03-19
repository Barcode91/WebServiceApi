package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Kuruluslar;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class HibernateKuruluslarDal implements IKuruluslarDal {
    private EntityManager entityManager;
    @Autowired
    public HibernateKuruluslarDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Kuruluslar> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Kuruluslar> kuruluslar = session.createQuery("from Kuruluslar",Kuruluslar.class).getResultList();
        return kuruluslar;
    }

    @Override
    @Transactional
    public void add(Kuruluslar kuruluslar) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(kuruluslar);

    }

    @Override
    @Transactional
    public void update(Kuruluslar kuruluslar) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(kuruluslar);

    }

    @Override
    @Transactional
    public void delete(Kuruluslar kuruluslar) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(kuruluslar);

    }

    @Override
    @Transactional
    public Kuruluslar getById( int id) {
        Session session = entityManager.unwrap(Session.class);
        Kuruluslar kuruluslar= session.get(Kuruluslar.class,id);
        return kuruluslar;
    }
}
