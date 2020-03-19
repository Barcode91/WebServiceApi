package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Personel;

import java.util.List;

public interface IPersonelService {
    List<Personel> getAll();
    void add(Personel personel);
    void update(Personel personel);
    void delete(Personel personel);
    Personel getById(int id);

}
