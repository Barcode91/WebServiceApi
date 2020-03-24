package com.digiadvert.ReklamOtomasyon.Service;


import com.digiadvert.ReklamOtomasyon.HibernateEntities.Reklamlar;

import java.util.List;

public interface IReklamlarService {
    List<Reklamlar> getAll();
    void add(Reklamlar reklamlar);
    void update(Reklamlar reklamlar);
    void delete(Reklamlar reklamlar);
    Reklamlar getById(int id);
    List<Reklamlar> getAllReklamState(String state);
    Reklamlar getMusteriReklamState(String reklamNo);
}
