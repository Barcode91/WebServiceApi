package com.digiadvert.ReklamOtomasyon.DataAccessLayer;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Sirket;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
public interface ISirketDal {
    List<Sirket> getAll();
    void add (Sirket sirket);
    void update(Sirket sirket);
    void delete (Sirket sirket);
    Sirket getById(int id);

}

