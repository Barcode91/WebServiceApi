package com.digiadvert.ReklamOtomasyon.HibernateEntities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "pano")
public class Pano {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pano_no")
    private String panoNo;

    @Column(name = "kurulus_no")
    private String kurulusNo;

    @Column(name = "adres")
    private String adres;

    @Column(name = "aktiflik_durumu")
    private String aktiflikDurumu;
    public Pano(){}
    public Pano(String panoNo, String kurulusNo,  String adres,  String aktiflikDurumu) {
        this.panoNo = panoNo;
        this.kurulusNo = kurulusNo;
        this.adres = adres;
        this.aktiflikDurumu = aktiflikDurumu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public String getPanoNo() {
        return panoNo;
    }

    public void setPanoNo(String panoNo) {
        this.panoNo = panoNo;
    }

    public String getKurulusNo() {
        return kurulusNo;
    }

    public void setKurulusNo(String kurulusNo) {
        this.kurulusNo = kurulusNo;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getAktiflikDurumu() {
        return aktiflikDurumu;
    }

    public void setAktiflikDurumu(String aktiflikDurumu) {
        this.aktiflikDurumu = aktiflikDurumu;
    }
}
