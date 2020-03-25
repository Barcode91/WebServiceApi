package com.digiadvert.ReklamOtomasyon.HibernateEntities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "reklamlar")
public class Reklamlar {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id değerninin üretileceği ifade edilir
    private int id;

    @Column(name="reklamNo")
    private String reklamNo;

    @Column(name="sirketNo")
    private String sirketNo;

    @Column(name="panoNo")
    private String panoNo;

    @Column(name="resim_path")
    private String resimPath;

    @Column(name = "baslangic_tarihi")
    private Date basTarih;

    @Column(name = "bitis_tarihi")
    private Date bitTarih;

    @Column(name = "reklam_durum")
    private String reklamDurum;

    @Column(name = "resim_data")
    private byte [] resimData;

    //private MultipartFile imageFile;

    public Reklamlar (){}

    public Reklamlar(String reklamNo, String sirketNo, String panoNo, String resimPath, Date basTarih, Date bitTarih, String reklamDurum, byte[] resimData) {
        this.reklamNo = reklamNo;
        this.sirketNo = sirketNo;
        this.panoNo = panoNo;
        this.resimPath = resimPath;
        this.basTarih = basTarih;
        this.bitTarih = bitTarih;
        this.reklamDurum = reklamDurum;
        this.resimData = resimData;
        //this.imageFile = imageFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReklamNo() {
        return reklamNo;
    }

    public void setReklamNo(String reklamNo) {
        this.reklamNo = reklamNo;
    }

    public String getSirketNo() {
        return sirketNo;
    }

    public void setSirketNo(String sirketNo) {
        this.sirketNo = sirketNo;
    }

    public String getPanoNo() {
        return panoNo;
    }

    public void setPanoNo(String panoNo) {
        this.panoNo = panoNo;
    }

    public String getResimPath() {
        return resimPath;
    }

    public void setResimPath(String resimPath) {
        this.resimPath = resimPath;
    }

    public Date getBasTarih() {
        return basTarih;
    }

    public void setBasTarih(Date basTarih) {
        this.basTarih = basTarih;
    }

    public Date getBitTarih() {
        return bitTarih;
    }

    public void setBitTarih(Date bitTarih) {
        this.bitTarih = bitTarih;
    }

    public String getReklamDurum() {
        return reklamDurum;
    }

    public void setReklamDurum(String reklamDurum) {
        this.reklamDurum = reklamDurum;
    }

    public byte[] getResimData() {
        return resimData;
    }

    public void setResimData(byte[] resimData) {
        this.resimData = resimData;
    }

    /*
    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

     */
}
