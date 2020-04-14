package com.digiadvert.ReklamOtomasyon.RestApi;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Reklamlar;
import com.digiadvert.ReklamOtomasyon.Service.IReklamlarService;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/reklam")
@CrossOrigin(origins = "http://localhost:4200")
public class ReklamlarController {
    private IReklamlarService reklamlarService;
    @Autowired
    public ReklamlarController(IReklamlarService reklamlarService) {
        this.reklamlarService = reklamlarService;
    }
    @GetMapping("/reklamlar")
    public List<Reklamlar> get (){
        System.out.println(this.reklamlarService.getAll().size());
        return this.reklamlarService.getAll();
    }
/*
    @PostMapping("/add") // postman form-data kısmında bir adet resim ve 1 adet json dosyası ile test edilir
    public void add(@RequestPart Reklamlar reklamlar) {
         System.out.println(imageFile.getContentType()+imageFile.getOriginalFilename());  @RequestPart ("imageFile") MultipartFile imageFile
        byte[] bytes = imageFile.getBytes();
        reklamlar.setResimData(bytes);
        this.reklamlarService.add(reklamlar);
    }


    @PostMapping("/update") // postman form-data kısmında bir adet resim ve 1 adet json dosyası ile test edilir
    public void update(@RequestPart ("reklamlar") Reklamlar reklamlar, @RequestPart ("imageFile") MultipartFile imageFile ) throws IOException {
        System.out.println(imageFile.getContentType()+imageFile.getOriginalFilename());
        byte[] bytes = imageFile.getBytes();
        reklamlar.setResimData(bytes);
        this.reklamlarService.update(reklamlar);
    }*/
    @PostMapping("/add")
    public void add(@RequestBody Reklamlar reklamlar ) throws IOException {
        this.reklamlarService.add(reklamlar);
    }

    @PostMapping("/updateByReklamNo/{reklamNo},{aktiflikDurumu}")
    public void updateByReklamNo(@PathVariable String reklamNo,@PathVariable String aktiflikDurumu) {
        this.reklamlarService.updateByReklamNo(reklamNo,aktiflikDurumu);
    }

    @PostMapping("/update")
    public void update(@RequestBody Reklamlar reklamlar){
        this.reklamlarService.update(reklamlar);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Reklamlar reklamlar){
        this.reklamlarService.delete(reklamlar);
    }

    @GetMapping("/reklam/{id}")
    public Reklamlar getId (@PathVariable int id){
        System.out.println(this.reklamlarService.getAll().size());
        return this.reklamlarService.getById(id);

    }

    @GetMapping("/durumlar") //localhost:8082/api/reklam/durumlar/?state=a
    public List<Reklamlar> getAllAdvState(@RequestParam String state){
        // Tüm reklamlar getirilir
        return this.reklamlarService.getAllReklamState(state);
    }

    @GetMapping("/musteri") //localhost:8082/api/reklam/musteri/?state=12323
    public List<Reklamlar> getCliAdvState(@RequestParam String musteriNo){
        //müşterinin bir reklamı getirilir Zaten bir tane reklam verebiliyor gibi gözüküyor :))))
        return this.reklamlarService.getMusteriReklamState(musteriNo);
    }

    @PostMapping("/cihaz/reklamlar") // mac adresi gelen orange pi ye reklamlarını gönderecek
    public List<Reklamlar> getPanoReklam(@RequestParam String panoNo){
        return this.reklamlarService.getPanoReklam(panoNo);


    }


    @PostMapping("/upload")
    @CrossOrigin(origins = "http://localhost:4200")
    public String UploadImage(@RequestParam ("imageFile") MultipartFile imageFile){
        String  path=null ;
        try { //  POSTMAN -> POST METODU BODY SEÇİLİR FORM-DATA SEÇİLİR KEY=İMAGEFİLE VALUE İSE FİLE SEÇİLİR.
            path = this.reklamlarService.saveImage(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;

        /* !!!! FURKAN ŞİMDİ REKLAM EKLEME İŞLEMİ ŞU ŞEKİLDE OLSUN *
            1. TEXTBOXLARI DOLDURSUN
            2. RESİM SEÇSİN
            3. RESİMİ UPLOAD ETSİN (UPLOAD ETTİKTEN SONRA BACKEND TARAFINDAN )
            4. DAHA SONRA VERİTABANINA KAYIR ETMEK ÜZERE KAYDET BUTONUNA BASSIN.



        /
         */

    }


    @PostMapping("/test")
    public String UploadtestImage(@RequestPart("reklam") Reklamlar reklam, @RequestPart ("imageFile") MultipartFile imageFile){
        String path=null;
        try { //  POSTMAN -> POST METODU BODY SEÇİLİR FORM-DATA SEÇİLİR KEY=İMAGEFİLE VALUE İSE FİLE SEÇİLİR.
            System.out.println("gelen veri :" + reklam.getId());

            path = this.reklamlarService.saveImage(imageFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;


    }

}
