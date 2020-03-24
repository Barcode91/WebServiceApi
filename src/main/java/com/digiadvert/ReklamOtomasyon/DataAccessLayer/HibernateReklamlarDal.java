package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Reklamlar;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
@CrossOrigin(origins = "http://localhost:4200")
public class HibernateReklamlarDal implements IReklamlarDal {
    private EntityManager entityManager;
    @Autowired
    public HibernateReklamlarDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Reklamlar> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Reklamlar> reklamlars = session.createQuery("from Reklamlar",Reklamlar.class).getResultList();
        return reklamlars;
    }

    @Override
    @Transactional
    public void add(Reklamlar reklamlar) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(reklamlar);

    }

    @Override
    @Transactional
    public void update(Reklamlar reklamlar) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(reklamlar);

    }

    @Override
    @Transactional
    public void delete(Reklamlar reklamlar) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(reklamlar);

    }

    @Override
    @Transactional
    public Reklamlar getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Reklamlar.class,id);
    }

    @Override
    public List<Reklamlar> getAllReklamState(String state) {
        Session session = entityManager.unwrap(Session.class);
        List<Reklamlar> reklamlar = session.createQuery("from Reklamlar r where r.reklamDurum=:durum",Reklamlar.class)
                .setParameter("durum",state).getResultList();
        return reklamlar;
    }

    @Override
    public Reklamlar getMusteriReklamState(String reklamNo) { // müşterinin sadece bir reklamını getir.
        Session session = entityManager.unwrap(Session.class);
        Reklamlar reklam = session.createQuery("from Reklamlar r where r.reklamNo=:rekNo",Reklamlar.class)
                .setParameter("rekNo",reklamNo).getSingleResult();
        return reklam;
    }
}
