package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Musteri;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
        Musteri musteriToDelete = session.get(Musteri.class,musteri.getId());
        session.delete(musteriToDelete);

    }

    @Override
    public Musteri getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Musteri musteri = session.get(Musteri.class,id);
        return musteri;
    }

    @Override
    public Musteri logInControl(String tcNo, String sifre) {
        Session session = entityManager.unwrap(Session.class);
        Musteri musteri =null;
        try {
           musteri = session.createQuery("from Musteri m where m.tcNo= :tc and m.sifre=:pass",Musteri.class)
                    .setParameter("tc",tcNo)
                    .setParameter("pass",sifre).getSingleResult();

        } catch (NoResultException e){
            musteri=new Musteri();
            musteri.setId(0);
        }
            return musteri;

    }


}
