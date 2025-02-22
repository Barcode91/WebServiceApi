package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Kuruluslar;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
//sanal sql komutlarını yazcağın data yonetcegın yer
import javax.persistence.EntityManager;
import java.util.List;
@Repository
@CrossOrigin(origins = "http://localhost:4200")
public class HibernateKuruluslarDal implements IKuruluslarDal {
    private EntityManager entityManager;
    @Autowired // otomatık baglamaya yarıyo hıbernet mı yoksa entıtyfrıre mı
    public HibernateKuruluslarDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // ıslem felan yarıda kalırsa yaptıgı ıslemı gerı alıyo
    public List<Kuruluslar> getAll() {
        Session session = entityManager.unwrap(Session.class); //db ıle aradan baglantı
        //tablo cagırmıyo bızım olustdugumuz sınıfı cagırıyor
        List<Kuruluslar> kuruluslar = session.createQuery("from Kuruluslar",Kuruluslar.class).getResultList();
        return kuruluslar;
    }

    @Override
    @Transactional
    public void add(Kuruluslar kuruluslar) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(kuruluslar);

    }

    @Override
    @Transactional
    public void update(Kuruluslar kuruluslar) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(kuruluslar);

    }

    @Override
    @Transactional
    public void delete(Kuruluslar kuruluslar) {
        Session session = entityManager.unwrap(Session.class);
        Kuruluslar kuruluslarToDelete = session.get(Kuruluslar.class,kuruluslar.getId());
        session.delete(kuruluslarToDelete);

    }

    @Override
    @Transactional
    public Kuruluslar getById( int id) {
        Session session = entityManager.unwrap(Session.class);
        Kuruluslar kuruluslar= session.get(Kuruluslar.class,id);
        return kuruluslar;
    }
}
