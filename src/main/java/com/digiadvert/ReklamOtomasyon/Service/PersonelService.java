package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.DataAccessLayer.IPersonelDal;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Personel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PersonelService implements IPersonelService{
    private IPersonelDal personelDal;
    @Autowired
    public PersonelService(IPersonelDal personelDal) {
        this.personelDal = personelDal;
    }


    @Override
    @Transactional
    public List<Personel> getAll() {
        return this.personelDal.getAll();
    }

    @Override
    @Transactional
    public void add(Personel personel) {
        this.personelDal.add(personel);

    }

    @Override
    @Transactional
    public void update(Personel personel) {
        this.personelDal.update(personel);

    }

    @Override
    @Transactional
    public void delete(Personel personel) {
        this.personelDal.delete(personel);

    }

    @Override
    @Transactional
    public Personel getById(int id) {
        return this.personelDal.getById(id);
    }
}
