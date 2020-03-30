package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Pano;

import java.util.List;

public interface IPanoService {
    List<Pano> getAll();
    void add (Pano pano);
    void update(Pano pano);
    void updateByPanoNo(String panoNo, String aktiflikDurumu);
    void delete (Pano pano);
    Pano getById(int id);
    List<Pano> getAdvState(String panoNo,String state);
    List<Pano> getPanoState(String state);
}
