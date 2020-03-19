package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Kuruluslar;

import java.util.List;

public interface IKuruluslarService {
    List<Kuruluslar> getAll();
    void add(Kuruluslar kuruluslar);
    void update(Kuruluslar kuruluslar);
    void delete(Kuruluslar kuruluslar);
    Kuruluslar getById(int id);
}
