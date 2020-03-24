package com.digiadvert.ReklamOtomasyon.HibernateEntities;

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

    @Column(name="resim_ad")
    private String resimAd;

    @Column(name = "resim_data")
    private byte [] resimData;

    @Column(name = "baslangic_tarihi")
    private Date basTarih;

    @Column(name = "bitis_tarihi")
    private Date bitTarih;

    @Column(name = "reklam_durum")
    private String reklamDurum;

    public Reklamlar (){}
    public Reklamlar(String reklamNo, String sirketNo, String panoNo, String resimAd, byte[] resimData, Date basTarih, Date bitTarih, String reklamDurum) {
        this.reklamNo = reklamNo;
        this.sirketNo = sirketNo;
        this.panoNo = panoNo;
        this.resimAd = resimAd;
        this.resimData = resimData;
        this.basTarih = basTarih;
        this.bitTarih = bitTarih;
        this.reklamDurum = reklamDurum;
    }

    public String getResimAd() {
        return resimAd;
    }

    public void setResimAd(String resimAd) {
        this.resimAd = resimAd;
    }

    public byte[] getResimData() {
        return resimData;
    }

    public void setResimData(byte[] resimData) {
        this.resimData = resimData;
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


}
