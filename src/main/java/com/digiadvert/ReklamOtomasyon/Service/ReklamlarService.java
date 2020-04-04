package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.DataAccessLayer.IReklamlarDal;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Reklamlar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
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
    public void add(Reklamlar reklamlar) throws IOException {
        /*
        try {
            byte[] bytes = reklamlar.getImageFile().getBytes();
            reklamlar.setResimData(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } */

            resimDataEkle(reklamlar);


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
    public void updateByReklamNo(String reklamNo, String aktiflikDurumu) {
        this.reklamlarDal.updateByReklamNo(reklamNo,aktiflikDurumu);
    }

    @Override
    @Transactional
    public Reklamlar getById(int id) {
        return this.reklamlarDal.getById(id);
    }

    @Override
    public List<Reklamlar> getAllReklamState(String state) {
        return this.reklamlarDal.getAllReklamState(state);
    }

    @Override
    public List<Reklamlar> getMusteriReklamState(String musteriNo) {
        return this.reklamlarDal.getMusteriReklamState(musteriNo);
    }

    @Override
    @CrossOrigin(origins = "http://localhost:4200")
    public String saveImage(MultipartFile imageFile) throws Exception {
        String resimPath=null;
        String folder = "/home/memo/Desktop/"; // serverda kayıt edilecek klasör yolu
        if(imageFile.getContentType().startsWith("image")){ // dosya tipi kontolü
            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get(folder+imageFile.getOriginalFilename());
            Files.write(path,bytes);
            //System.out.println(path.toString()+"    "+ path1.getFileName()+"   "+imageFile.getContentType());
            System.out.println("path verisi :"+path.toString());
            //path = Paths.get("./assets/reklamFotograflari"+imageFile.getOriginalFilename());
            resimPath=path.toString();
        }
        else
            resimPath="hata";


        return resimPath; // resimin kayıt yolu döndürülür.
    }


    @Override
    public List<Reklamlar> getPanoReklam(String panoNo) {
        return this.reklamlarDal.getPanoReklam(panoNo);
    }

    @Override
    public void resimDataEkle(Reklamlar reklamlar) throws IOException { // klasörde olan resmi database ekler :)))
        String path = reklamlar.getResimPath();
        BufferedImage res = ImageIO.read(new File(path));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(res,"jpg",bos);
        byte [] resimbyte = bos.toByteArray();
        reklamlar.setResimData(resimbyte);

    }


}
