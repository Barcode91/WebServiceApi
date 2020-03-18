package com.digiadvert.ReklamOtomasyon.RestApi;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Musteri;
import com.digiadvert.ReklamOtomasyon.Service.IMusteriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MusteriController {
    private IMusteriService musteriService;

    @Autowired
    public MusteriController(IMusteriService musteriService) {
        this.musteriService = musteriService;
    }
    @GetMapping("/musteri")
    public List<Musteri> get (){
        System.out.println(this.musteriService.getAll().size());
        return this.musteriService.getAll();

    }

    @PostMapping("/add")
    public void add(@RequestBody Musteri musteri){
        this.musteriService.add(musteri);
    }

    @PostMapping("/update")
    public void update(@RequestBody Musteri musteri){
        this.musteriService.update(musteri);

    }
    @PostMapping("/delete")
    public void delete(@RequestBody Musteri musteri){
        this.musteriService.delete(musteri);


    }
    @GetMapping("/musteri/{id}")
    public Musteri getId (@PathVariable int id){
        System.out.println(this.musteriService.getAll().size());
        return this.musteriService.getById(id);

    }

}
