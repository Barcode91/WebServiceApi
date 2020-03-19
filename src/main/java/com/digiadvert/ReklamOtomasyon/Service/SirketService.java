package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.DataAccessLayer.ISirketDal;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Sirket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SirketService implements ISirketService{
    private ISirketDal sirketDal;
    @Autowired
    public SirketService(ISirketDal sirketDal) {
        this.sirketDal = sirketDal;
    }

    @Override
    @Transactional
    public List<Sirket> getAll() {
        return this.sirketDal.getAll();
    }

    @Override
    @Transactional
    public void add(Sirket sirket) {
        this.sirketDal.add(sirket);

    }

    @Override
    @Transactional
    public void update(Sirket sirket) {
        this.sirketDal.update(sirket);

    }

    @Override
    @Transactional
    public void delete(Sirket sirket) {
        this.sirketDal.delete(sirket);

    }

    @Override
    @Transactional
    public Sirket getById(int id) {
        return this.sirketDal.getById(id);
    }
}
