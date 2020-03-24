package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.DataAccessLayer.IReklamlarDal;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Reklamlar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@Service
@CrossOrigin(origins = "http://localhost:4200")
public class ReklamlarService implements IReklamlarService {

    private IReklamlarDal reklamlarDal;
    @Autowired
    public ReklamlarService(IReklamlarDal reklamlarDal) {
        this.reklamlarDal = reklamlarDal;
    }

    @Override
    @Transactional
    public List<Reklamlar> getAll() {
        return this.reklamlarDal.getAll();
    }

    @Override
    @Transactional
    public void add(Reklamlar reklamlar) {
        this.reklamlarDal.add(reklamlar);
    }

    @Override
    @Transactional
    public void update(Reklamlar reklamlar) {
        this.reklamlarDal.update(reklamlar);
    }

    @Override
    @Transactional
    public void delete(Reklamlar reklamlar) {
        this.reklamlarDal.delete(reklamlar);

    }

    @Override
    @Transactional
    public Reklamlar getById(int id) {
        return this.reklamlarDal.getById(id);
    }

    @Override
    public List<Reklamlar> getAllReklamState(String state) {
        return this.getAllReklamState(state);
    }

    @Override
    public Reklamlar getMusteriReklamState(String reklamNo) {
        return this.getMusteriReklamState(reklamNo);
    }
}
