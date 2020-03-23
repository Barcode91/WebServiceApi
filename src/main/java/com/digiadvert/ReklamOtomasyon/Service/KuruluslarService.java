package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.DataAccessLayer.IKuruluslarDal;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Kuruluslar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class KuruluslarService implements IKuruluslarService {
    private IKuruluslarDal kuruluslarDal;
    @Autowired
    public KuruluslarService(IKuruluslarDal kuruluslarDal) {
        this.kuruluslarDal = kuruluslarDal;
    }

    //DOGRULATMALAR FELAN BURDA OLACAK KUCUK ISLETMELER BUNU GECIO
    @Override
    @Transactional
    public List<Kuruluslar> getAll() {
        return this.kuruluslarDal.getAll();
    }

    @Override
    @Transactional
    public void add(Kuruluslar kuruluslar) {
        this.kuruluslarDal.add(kuruluslar);
        //ıf(kuruluslar.ıd -- 5

    }

    @Override
    @Transactional
    public void update(Kuruluslar kuruluslar) {
        this.kuruluslarDal.update(kuruluslar);

    }

    @Override
    @Transactional
    public void delete(Kuruluslar kuruluslar) {
        this.kuruluslarDal.delete(kuruluslar);

    }

    @Override
    @Transactional
    public Kuruluslar getById(int id) {

        return this.kuruluslarDal.getById(id);
    }
}
