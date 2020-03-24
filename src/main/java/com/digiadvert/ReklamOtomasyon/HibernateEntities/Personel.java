package com.digiadvert.ReklamOtomasyon.HibernateEntities;


import javax.persistence.*;

@Entity
@Table(name = "personel")
public class Personel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id değerninin üretileceği ifade edilir
    private int id;

    @Column(name="kimlik")
    private String kimlik;

    @Column(name="tel_no")
    private String telNo;

    @Column(name="eposta")
    private String eposta;

    @Column(name="maas")
    private String maas;

    @Column(name="p_no")
    private String pNo;

    @Column(name="sifre")
    private String sifre;

    @Column(name="tc_no")
    private String tcNo;



    public Personel (){}
    public Personel(String kimlik, String telNo, String eposta, String maas, String pNo, String sifre, String tcNo) {
        this.kimlik = kimlik;
        this.telNo = telNo;
        this.eposta = eposta;
        this.maas = maas;
        this.pNo = pNo;
        this.sifre=sifre;
        this.tcNo=tcNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKimlik() {
        return kimlik;
    }

    public void setKimlik(String kimlik) {
        this.kimlik = kimlik;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getMaas() {
        return maas;
    }

    public void setMaas(String maas) {
        this.maas = maas;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
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
}



