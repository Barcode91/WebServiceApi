package com.digiadvert.ReklamOtomasyon.Service;

import com.digiadvert.ReklamOtomasyon.DataAccessLayer.IPersonelDal;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Personel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
@Service
public class PersonelService implements IPersonelService{
    private IPersonelDal personelDal;
    @Autowired
    public PersonelService(IPersonelDal personelDal) {
        this.personelDal = personelDal;
    }


    @Override
    @Transactional
    public List<Personel> getAll() {
        return this.personelDal.getAll();
    }

    @Override
    @Transactional
    public void add(Personel personel) {
        hashleme(personel);
        this.personelDal.add(personel);

    }

    @Override
    @Transactional
    public void update(Personel personel) {
        hashleme(personel);
        this.personelDal.update(personel);

    }

    @Override
    @Transactional
    public void delete(Personel personel) {
        this.personelDal.delete(personel);

    }

    @Override
    @Transactional
    public Personel getById(int id) {
        return this.personelDal.getById(id);
    }

    @Override
    public Personel logInControl(String tcNo, String sifre) {
        sifre = hashleme(sifre);
        return this.personelDal.logInControl(tcNo,sifre);
    }


    public void hashleme(Personel personel) {
        try {
            personel.setSifre(stringToHexString(getSHA(personel.getSifre())));
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
