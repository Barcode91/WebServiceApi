package com.digiadvert.ReklamOtomasyon.DataAccessLayer;


import com.digiadvert.ReklamOtomasyon.HibernateEntities.Reklamlar;

import java.util.List;

public interface IReklamlarDal {
    List<Reklamlar> getAll();
    void add (Reklamlar reklamlar);
    void update(Reklamlar reklamlar);
    void delete (Reklamlar reklamlar);
    Reklamlar getById(int id);
    List<Reklamlar> getAllReklamState(String state);
    Reklamlar getMusteriReklamState(String reklamNo);
}
