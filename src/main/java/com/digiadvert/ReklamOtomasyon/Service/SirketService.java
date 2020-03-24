package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.DataAccessLayer.HibernateSirketDal;
import com.digiadvert.ReklamOtomasyon.DataAccessLayer.ISirketDal;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Sirket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service

@CrossOrigin(origins = "http://localhost:4200")
public class SirketService implements ISirketService{
    private ISirketDal sirketDal;
    private HibernateSirketDal hibernateSirketDal = new HibernateSirketDal();

    @Autowired
    public SirketService(ISirketDal sirketDal) {
        this.sirketDal = sirketDal;
    }

    @Override
    @Transactional
    public List<Sirket> getAll() {
        System.out.println("SERVICE GET FUNCTION ");
        return this.sirketDal.getAll();
    }

    @Override
    @Transactional
    public void add(Sirket sirket) {
        System.out.println("SERVICE GET FUNCTION ");
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
