package com.digiadvert.ReklamOtomasyon.DataAccessLayer;


import com.digiadvert.ReklamOtomasyon.HibernateEntities.Musteri;

import java.util.List;

public interface IMusteriDal {
   List<Musteri> getAll();
   void add (Musteri musteri);
   void update(Musteri musteri);
   void delete (Musteri musteri);
   Musteri getById(int id);

}
