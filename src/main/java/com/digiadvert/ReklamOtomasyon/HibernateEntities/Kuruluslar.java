package com.digiadvert.ReklamOtomasyon.HibernateEntities;
import javax.persistence.*;

@Entity
@Table(name = "kuruluslar")
public class Kuruluslar {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id değerninin üretileceği ifade edilir
    private int id;

    @Column(name="kurulusNo")
    private String kurulusNo;

    @Column(name="kurulusAdi")
    private String kurulusAdi;

    @Column(name="kurulusAdresi")
    private String kurulusAdresi;

    @Column(name="kurulsuTelNo")
    private String kurulsuTelNo;

    @Column(name="kurulusEposta")
    private String kurulusEposta;

    public Kuruluslar (){}

    public Kuruluslar(String kurulusNo, String kurulusAdi, String kurulusAdresi, String kurulsuTelNo, String kurulusEposta) {
        this.kurulusNo = kurulusNo;
        this.kurulusAdi = kurulusAdi;
        this.kurulusAdresi = kurulusAdresi;
        this.kurulsuTelNo = kurulsuTelNo;
        this.kurulusEposta = kurulusEposta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKurulusNo() {
        return kurulusNo;
    }

    public void setKurulusNo(String kurulusNo) {
        this.kurulusNo = kurulusNo;
    }

    public String getKurulusAdi() {
        return kurulusAdi;
    }

    public void setKurulusAdi(String kurulusAdi) {
        this.kurulusAdi = kurulusAdi;
    }

    public String getKurulusAdresi() {
        return kurulusAdresi;
    }

    public void setKurulusAdresi(String kurulusAdresi) {
        this.kurulusAdresi = kurulusAdresi;
    }

    public String getKurulsuTelNo() {
        return kurulsuTelNo;
    }

    public void setKurulsuTelNo(String kurulsuTelNo) {
        this.kurulsuTelNo = kurulsuTelNo;
    }

    public String getKurulusEposta() {
        return kurulusEposta;
    }

    public void setKurulusEposta(String kurulusEposta) {
        this.kurulusEposta = kurulusEposta;
    }
}
