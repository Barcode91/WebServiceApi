package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Sirket;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
@CrossOrigin(origins = "http://localhost:4200")
public class HibernateSirketDal implements ISirketDal {
    private EntityManager entityManager;
    @Autowired
    public HibernateSirketDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public HibernateSirketDal(){}

    @Override
    @Transactional
    public List<Sirket> getAll() {
        Session session = entityManager.unwrap(Session.class);
        System.out.println("data access layer GET FUNCTION ");
        List<Sirket> sirketler = session.createQuery("from  Sirket ",Sirket.class).getResultList();
        return sirketler;
    }

    @Override
    @Transactional
    public void add(Sirket sirket) {
        Session session = entityManager.unwrap(Session.class);
        System.out.println("REST API GET FUNCTION ");
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
        Sirket sirketToDelete = session.get(Sirket.class,sirket.getId()); // Veri tabanından ilgili id nesnesi tekrar çekilir
        session.delete(sirketToDelete);

    }

    @Override
    @Transactional
    public Sirket getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Sirket sirket = session.get(Sirket.class,id);
        return sirket;
    }
}
