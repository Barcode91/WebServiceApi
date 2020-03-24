package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Pano;

import java.util.List;

public interface IPanoDal {
    List<Pano> getAll();
    void add (Pano pano);
    void update(Pano pano);
    void delete (Pano pano);
    Pano getById(int id);
    List<Pano> getAdvState(String panoNo,String state);
    List<Pano> getPanoState(String state);




}
