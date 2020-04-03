package com.digiadvert.ReklamOtomasyon.Service;


import com.digiadvert.ReklamOtomasyon.HibernateEntities.Reklamlar;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IReklamlarService {
    List<Reklamlar> getAll();
    void add(Reklamlar reklamlar) throws IOException;
    void update(Reklamlar reklamlar);
    void delete(Reklamlar reklamlar);
    void updateByReklamNo(String reklamNo, String aktiflikDurumu);
    Reklamlar getById(int id);
    List<Reklamlar> getAllReklamState(String state);
    List<Reklamlar> getMusteriReklamState(String musteriNo);
    String saveImage(MultipartFile imageFile) throws Exception;
    List<Reklamlar> getPanoReklam(String panoNo);
    void resimDataEkle(Reklamlar reklamlar) throws IOException;
}
