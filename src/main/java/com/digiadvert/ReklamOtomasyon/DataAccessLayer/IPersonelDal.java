package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Personel;

import java.util.List;

public interface IPersonelDal {
    List<Personel> getAll();
    void add (Personel personel);
    void update(Personel personel);
    void delete (Personel personel);
    Personel getById(int id);

}
