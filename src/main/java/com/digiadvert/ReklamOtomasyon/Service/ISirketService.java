package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Musteri;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Sirket;

import java.util.List;

public interface ISirketService {
    List<Sirket> getAll();
    void add(Sirket sirket);
    void update(Sirket sirket);
    void delete(Sirket sirket);
    Sirket getById(int id);


}

