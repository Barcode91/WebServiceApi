package com.digiadvert.ReklamOtomasyon.HibernateEntities;

import javax.annotation.processing.Generated;
import javax.persistence.*;


@Entity // Veritabanı Nesnesi Olduğunu Belirtir
@Table(name="musteri") // Hangi Tabloyu işaret Ettiği
public class Musteri {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id değerninin üretileceği ifade edilir
    private int id;

    @Column(name="tc_no")
    private String tcNo;

    @Column(name="kimlik")
    private String kimlik;

    @Column(name="eposta")
    private String eposta;

    @Column(name="reklam_no")
    private String reklamNo;

    @Column(name="sirket_no")
    private String sirketNO;

    @Column(name="sifre")
    private String sifre;

    public Musteri(){}
    public Musteri(int id, String tcNo, String kimlik, String eposta, String reklamNo, String sirketNO) {
        this.id = id;
        this.tcNo = tcNo;
        this.kimlik = kimlik;
        this.eposta = eposta;
        this.reklamNo = reklamNo;
        this.sirketNO = sirketNO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getKimlik() {
        return kimlik;
    }

    public void setKimlik(String kimlik) {
        this.kimlik = kimlik;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getReklamNo() {
        return reklamNo;
    }

    public void setReklamNo(String reklamNo) {
        this.reklamNo = reklamNo;
    }

    public String getSirketNO() {
        return sirketNO;
    }

    public void setSirketNO(String sirketNO) {
        this.sirketNO = sirketNO;
    }
}
