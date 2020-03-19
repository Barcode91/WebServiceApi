package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Sirket;
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
        return null;
    }

    @Override
    @Transactional
    public void add(Sirket sirket) {

    }

    @Override
    @Transactional
    public void update(Sirket sirket) {

    }

    @Override
    @Transactional
    public void delete(Sirket sirket) {

    }

    @Override
    @Transactional
    public Sirket getById(int Id) {
        return null;
    }
}
