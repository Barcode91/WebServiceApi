package com.digiadvert.ReklamOtomasyon.RestApi;
import com.digiadvert.ReklamOtomasyon.HibernateEntities.Personel;
import com.digiadvert.ReklamOtomasyon.Service.IPersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personel")
public class PersonelController {
    private IPersonelService personelService;
    @Autowired
    public PersonelController(IPersonelService personelService) {
        this.personelService = personelService;
    }

    @GetMapping("/personeller")
    public List<Personel> get(){
        return this.personelService.getAll();
    }


    @PostMapping("/add")
    public void add(@RequestBody Personel personel){
        this.personelService.add(personel);

    }
    @PostMapping("/update")
    public void update(@RequestBody Personel personel){
        this.personelService.update(personel);

    }

    @PostMapping("/delete")
    public void delete(@RequestBody Personel personel){
        this.personelService.delete(personel);

    }

    @GetMapping("/{id}")
    public Personel getById(@PathVariable int id){
        return this.personelService.getById(id);


    }


    @PostMapping("/login/{tcNo},{sifre}")
    public Personel login(@PathVariable String tcNo, @PathVariable String sifre ) {
        return this.personelService.logInControl(tcNo,sifre);

        // müsteri id 0 dönerse müşteri yok
        // 0 dan farklı dönerse müşteri class döner

    }

}
