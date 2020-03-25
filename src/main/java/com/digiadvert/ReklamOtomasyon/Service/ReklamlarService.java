package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.DataAccessLayer.IReklamlarDal;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Reklamlar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@Service
@CrossOrigin(origins = "http://localhost:4200")
public class ReklamlarService implements IReklamlarService {

    private IReklamlarDal reklamlarDal;
    @Autowired
    public ReklamlarService(IReklamlarDal reklamlarDal) {
        this.reklamlarDal = reklamlarDal;
    }

    @Override
    @Transactional
    public List<Reklamlar> getAll() {
        return this.reklamlarDal.getAll();
    }

    @Override
    @Transactional
    public void add(Reklamlar reklamlar) {
        /*
        try {
            byte[] bytes = reklamlar.getImageFile().getBytes();
            reklamlar.setResimData(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } */
        this.reklamlarDal.add(reklamlar);
    }

    @Override
    @Transactional
    public void update(Reklamlar reklamlar) {
        this.reklamlarDal.update(reklamlar);
    }

    @Override
    @Transactional
    public void delete(Reklamlar reklamlar) {
        this.reklamlarDal.delete(reklamlar);

    }

    @Override
    @Transactional
    public Reklamlar getById(int id) {
        return this.reklamlarDal.getById(id);
    }

    @Override
    public List<Reklamlar> getAllReklamState(String state) {
        return this.getAllReklamState(state);
    }

    @Override
    public Reklamlar getMusteriReklamState(String reklamNo) {
        return this.getMusteriReklamState(reklamNo);
    }

    @Override
    public String saveImage(MultipartFile imageFile) throws Exception {
        String resimPath=null;
        String folder = "/home/memo/Desktop/test/photo"; // serverda kayıt edilecek klasör yolu
        if(imageFile.getContentType().startsWith("image")){ // dosya tipi kontolü
            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get(folder+imageFile.getOriginalFilename());
            Files.write(path,bytes);
            //System.out.println(path.toString()+"    "+ path1.getFileName()+"   "+imageFile.getContentType());
            System.out.println("path verisi :"+path.toString());
            resimPath=path.toString();
        }
        else
            resimPath="hata";


        return resimPath; // resimin kayıt yolu döndürülür.
    }


}
