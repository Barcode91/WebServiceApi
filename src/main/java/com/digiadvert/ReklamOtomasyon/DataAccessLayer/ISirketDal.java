package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Sirket;

import java.util.List;

public interface ISirketDal {
    List<Sirket> getAll();
    void add (Sirket sirket);
    void update(Sirket sirket);
    void delete (Sirket sirket);
    Sirket getById(int id);

}

