package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Musteri;

import java.util.List;

public interface IMusteriService {
    List<Musteri> getAll();
    void add (Musteri musteri);
    void update(Musteri musteri);
    void delete (Musteri musteri);
    Musteri getById(int id);
}
