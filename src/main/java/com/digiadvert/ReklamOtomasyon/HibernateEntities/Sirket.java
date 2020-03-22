package com.digiadvert.ReklamOtomasyon.HibernateEntities;

import javax.persistence.*;

@Entity
@Table(name = "sirket")
public class Sirket {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id değerninin üretileceği ifade edilir
    private int id;

    @Column(name="sirketNo")
    private String sirketNo;

    @Column(name="sirket_adi")
    private String sirketAdi;

    @Column(name="sirketAdresi")
    private String sirketAdresi;

    @Column(name="sirketSektoru")
    private String sirketSektoru;

    @Column(name="sirketButcesi")
    private String sirketButcesi;

    @Column(name="sirketTelNo")
    private String sirketTelNo;
    public Sirket (){}
    public Sirket(String sirketNo, String sirketAdi, String sirketAdresi, String sirketSektoru, String sirketButcesi, String sirketTelNo) {
        this.sirketNo = sirketNo;
        this.sirketAdi = sirketAdi;
        this.sirketAdresi = sirketAdresi;
        this.sirketSektoru = sirketSektoru;
        this.sirketButcesi = sirketButcesi;
        this.sirketTelNo = sirketTelNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSirketNo() {
        return sirketNo;
    }

    public void setSirketNo(String sirketNo) {
        this.sirketNo = sirketNo;
    }

    public String getSirketAdi() {
        return sirketAdi;
    }

    public void setSirketAdi(String sirketAdi) {
        this.sirketAdi = sirketAdi;
    }

    public String getSirketAdresi() {
        return sirketAdresi;
    }

    public void setSirketAdresi(String sirketAdresi) {
        this.sirketAdresi = sirketAdresi;
    }

    public String getSirketSektoru() {
        return sirketSektoru;
    }

    public void setSirketSektoru(String sirketSektoru) {
        this.sirketSektoru = sirketSektoru;
    }

    public String getSirketButcesi() {
        return sirketButcesi;
    }

    public void setSirketButcesi(String sirketButcesi) {
        this.sirketButcesi = sirketButcesi;
    }

    public String getSirketTelNo() {
        return sirketTelNo;
    }

    public void setSirketTelNo(String sirketTelNo) {
        this.sirketTelNo = sirketTelNo;
    }
}
