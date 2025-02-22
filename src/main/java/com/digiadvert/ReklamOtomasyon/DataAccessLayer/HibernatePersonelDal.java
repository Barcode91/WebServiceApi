package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Personel;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public class HibernatePersonelDal implements IPersonelDal {
    private EntityManager entityManager;
    @Autowired
    public HibernatePersonelDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Personel> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Personel> personels = session.createQuery("from Personel",Personel.class).getResultList();
        return personels;
    }

    @Override
    @Transactional
    public void add(Personel personel) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(personel);

    }

    @Override
    @Transactional
    public void update(Personel personel) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(personel); 


    }

    @Override
    @Transactional
    public void delete(Personel personel) {
        Session session = entityManager.unwrap(Session.class);
        Personel personelToDelete = session.get(Personel.class,personel.getId());
        session.delete(personelToDelete);

    }

    @Override
    @Transactional
    public Personel getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Personel personel = session.get(Personel.class,id);
        return personel;
    }

    @Override
    public Personel logInControl(String tcNo, String sifre) {
        Session session = entityManager.unwrap(Session.class);
        Personel personel =null;
        try {
            personel = session.createQuery("from Personel m where m.tcNo= :tc and m.sifre=:pass",Personel.class)
                    .setParameter("tc",tcNo)
                    .setParameter("pass",sifre).getSingleResult();

        } catch (NoResultException e){
            personel=new Personel();
            personel.setId(0);
        }
        return personel;

    }


}
