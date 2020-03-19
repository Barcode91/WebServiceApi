package com.digiadvert.ReklamOtomasyon.HibernateEntities;

import javax.persistence.*;

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

    @Column(name="ilanResimPath")
    private String ilanResimPath;
    public Reklamlar (){}
    public Reklamlar(String reklamNo, String sirketNo, String panoNo, String ilanResimPath) {
        this.reklamNo = reklamNo;
        this.sirketNo = sirketNo;
        this.panoNo = panoNo;
        this.ilanResimPath = ilanResimPath;
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

    public String getIlanResimPath() {
        return ilanResimPath;
    }

    public void setIlanResimPath(String ilanResimPath) {
        this.ilanResimPath = ilanResimPath;
    }
}
