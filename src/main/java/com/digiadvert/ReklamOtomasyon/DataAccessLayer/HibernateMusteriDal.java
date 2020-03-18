package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Musteri;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class HibernateMusteriDal implements IMusteriDal {
    // Musteri nesnesi için hibernate operasyonlarının yazıldığı sınıf
    private EntityManager entityManager;

    // Musteri nesnesi için aşağıda çaılışan orm çözümünü implement etmeyi sağlar
    // projede hibernate olduğundan onu implement eder.
    @Autowired
    public HibernateMusteriDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional // Database oturumunu kontrol eder
    public List<Musteri> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Musteri> musteri = session.createQuery("from Musteri",Musteri.class).getResultList();
        return musteri;
    }

    @Override
    public void add(Musteri musteri) { // müşteri eklenir
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(musteri);


    }

    @Override
    public void update(Musteri musteri) { // müşteri güncellenir
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(musteri);

    }

    @Override
    public void delete(Musteri musteri) { // müşteri silinir
        Session session = entityManager.unwrap(Session.class);
        session.delete(musteri);

    }

    @Override
    public Musteri getById(int Id) {
        Session session = entityManager.unwrap(Session.class);
        Musteri musteri = session.get(Musteri.class,Id);
        return musteri;
    }


}
