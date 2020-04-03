package com.digiadvert.ReklamOtomasyon.DataAccessLayer;


import com.digiadvert.ReklamOtomasyon.HibernateEntities.Reklamlar;

import java.util.List;

public interface IReklamlarDal {
    List<Reklamlar> getAll();
    void add (Reklamlar reklamlar);
    void update(Reklamlar reklamlar);
    void delete (Reklamlar reklamlar);
    void updateByReklamNo(String reklamNo, String aktiflikDurumu);
    Reklamlar getById(int id);
    List<Reklamlar> getAllReklamState(String state);
    List<Reklamlar> getMusteriReklamState(String musteriNo);
    List<Reklamlar> getPanoReklam(String panoNo);
}
