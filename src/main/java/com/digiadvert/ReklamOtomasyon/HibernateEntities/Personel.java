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

    @Column(name="telNo")
    private String telNo;

    @Column(name="eposta")
    private String eposta;

    @Column(name="maas")
    private String maas;

    @Column(name="pNo")
    private String pNo;
    public Personel (){}
    public Personel(String kimlik, String telNo, String eposta, String maas, String pNo) {
        this.kimlik = kimlik;
        this.telNo = telNo;
        this.eposta = eposta;
        this.maas = maas;
        this.pNo = pNo;
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
}



