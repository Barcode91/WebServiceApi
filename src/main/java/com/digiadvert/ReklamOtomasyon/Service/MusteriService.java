package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.DataAccessLayer.IMusteriDal;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Musteri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@Service
@CrossOrigin(origins = "http://localhost:4200")
public class MusteriService implements IMusteriService {
    private IMusteriDal musteriDal;
    @Autowired
    public MusteriService(IMusteriDal musteriDal) {
        this.musteriDal = musteriDal;
    }

    @Override
    @Transactional
    public List<Musteri> getAll() {
        return this.musteriDal.getAll();
    }

    @Override
    @Transactional
    public void add(Musteri musteri) {
        System.out.println("MUSTERI SERVICE ADD FUNCTION ");
        this.musteriDal.add(musteri);

    }

    @Override
    @Transactional
    public void update(Musteri musteri) {
        this.musteriDal.update(musteri);

    }

    @Override
    @Transactional
    public void delete(Musteri musteri) {
        this.musteriDal.delete(musteri);

    }

    @Override
    @Transactional
    public Musteri getById(int id) {
        return this.musteriDal.getById(id);
    }
}
