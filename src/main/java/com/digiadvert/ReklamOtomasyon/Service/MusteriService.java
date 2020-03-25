package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.DataAccessLayer.IMusteriDal;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Musteri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
@Service
@CrossOrigin(origins = "http://localhost:4200")
public class MusteriService implements IMusteriService {
    private IMusteriDal musteriDal;
    @Autowired
    public MusteriService(IMusteriDal musteriDal) {
        this.musteriDal = musteriDal;
    }

    @Override
    @Transactional
    public List<Musteri> getAll() {
        return this.musteriDal.getAll();
    }

    @Override
    @Transactional
    public void add(Musteri musteri) {
        System.out.println("MUSTERI SERVICE ADD FUNCTION ");
        hashleme(musteri);
        this.musteriDal.add(musteri);

    }

    @Override
    @Transactional
    public void update(Musteri musteri) {
        hashleme(musteri);
        this.musteriDal.update(musteri);

    }

    @Override
    @Transactional
    public void delete(Musteri musteri) {
        this.musteriDal.delete(musteri);

    }

    @Override
    @Transactional
    public Musteri getById(int id) {
        return this.musteriDal.getById(id);
    }

    @Override
    public Musteri logInControl(String tcNo, String sifre) {
        sifre = hashleme(sifre);
        return this.musteriDal.logInControl(tcNo,sifre);
    }


    public void hashleme(Musteri musteri) {
        try {
            System.out.println("Musteri nesnesi geldi");
            musteri.setSifre(stringToHexString(getSHA(musteri.getSifre())));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public String hashleme(String sifre) {
        String hashToString =null;
        try {
            hashToString=  stringToHexString(getSHA(sifre));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(hashToString);
        return hashToString;

    }

    //SHA-256 HASH ALG.
    public byte[] getSHA(String sifre) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(sifre.getBytes(StandardCharsets.UTF_8));
    }
    // HASHLENMİŞ VERİNİN STRİNG HALİNE DÖNÜŞTÜRÜLMESİ
    public String stringToHexString(byte [] hashVeri){
        BigInteger number = new BigInteger(1, hashVeri);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
}
