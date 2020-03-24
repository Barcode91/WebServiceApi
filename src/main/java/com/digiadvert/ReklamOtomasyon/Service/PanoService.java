package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.DataAccessLayer.IPanoDal;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Pano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PanoService implements IPanoService{
    private IPanoDal panoDal;
    @Autowired
    public PanoService(IPanoDal panoDal) {
        this.panoDal = panoDal;
    }
    @Transactional
    @Override
    public List<Pano> getAll() {
        return this.panoDal.getAll();
    }
    @Transactional
    @Override
    public void add(Pano pano) {
        this.panoDal.add(pano);

    }
    @Transactional
    @Override
    public void update(Pano pano) {
        this.panoDal.update(pano);

    }
    @Transactional
    @Override
    public void delete(Pano pano) {
        this.panoDal.delete(pano);

    }
    @Transactional
    @Override
    public Pano getById(int id) {
        return  this.panoDal.getById(id);
    }
    @Transactional
    @Override
    public List<Pano> getAdvState(String panoNo, String state) {
        return this.panoDal.getAdvState(panoNo,state);
    }
    @Transactional
    @Override
    public List<Pano> getPanoState(String state) {
        return this.panoDal.getPanoState(state);
    }
}
