package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Kuruluslar;

import java.util.List;

public interface IKuruluslarDal {
    List<Kuruluslar> getAll();
    void add (Kuruluslar kuruluslar);
    void update(Kuruluslar kuruluslar);
    void delete (Kuruluslar kuruluslar);
    Kuruluslar getById(int id);
}
