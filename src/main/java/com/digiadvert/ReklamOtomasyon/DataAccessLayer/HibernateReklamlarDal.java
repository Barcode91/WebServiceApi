package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Reklamlar;
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
        return null;
    }

    @Override
    @Transactional
    public void add(Reklamlar reklamlar) {

    }

    @Override
    @Transactional
    public void update(Reklamlar reklamlar) {

    }

    @Override
    @Transactional
    public void delete(Reklamlar reklamlar) {

    }

    @Override
    @Transactional
    public Reklamlar getById(int Id) {
        return null;
    }
}
