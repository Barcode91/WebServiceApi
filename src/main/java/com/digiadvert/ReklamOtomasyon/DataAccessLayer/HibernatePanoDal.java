package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Pano;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@CrossOrigin(origins = "http://localhost:4200")
public class HibernatePanoDal implements IPanoDal {
    private EntityManager entityManager;
    @Autowired
    public HibernatePanoDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Pano> getAll() { // tüm panoları getirir
        Session session = entityManager.unwrap(Session.class);
        List<Pano> panos = session.createQuery("from Pano",Pano.class).getResultList();
        return panos;
    }

    @Override
    @Transactional
    public void add(Pano pano) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(pano);

    }

    @Override
    @Transactional
    public void update(Pano pano) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(pano);

    }

    @Override
    @Transactional
    public void delete(Pano pano) {
        Session session = entityManager.unwrap(Session.class);
        Pano panoToDelete = session.get(Pano.class,pano.getId());
        session.delete(panoToDelete);


    }

    @Override
    @Transactional
    public Pano getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Pano pano = session.get(Pano.class,id);
        return pano;
    }

    @Override
    @Transactional
    public List<Pano> getAdvState(String panoNo, String state) {
        // spesifik bir pano durumu getirir
        // a - aktif  p - pasif  b - bakımda
        Session session = entityManager.unwrap(Session.class);
        List<Pano> panos = session.createQuery("from Pano p where p.panoNo= :pNo and p.aktiflikDurumu=:durum ",Pano.class)
                .setParameter("pNo",panoNo)
                .setParameter("durum",state)
                .getResultList();
        return panos;
    }


    @Override
    public List<Pano> getPanoState(String state) {
        // panoları durumlarına göre getirir
        // a - aktif  p - pasif  b - bakımda
        Session session = entityManager.unwrap(Session.class);
        List<Pano> panos = session.createQuery("from Pano p where p.aktiflikDurumu=:durum ",Pano.class)
                .setParameter("durum",state)
                .getResultList();
        return panos;
    }
}
