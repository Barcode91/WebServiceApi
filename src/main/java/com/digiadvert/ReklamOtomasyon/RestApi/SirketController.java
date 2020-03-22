package com.digiadvert.ReklamOtomasyon.RestApi;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Sirket;
import com.digiadvert.ReklamOtomasyon.Service.ISirketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sirket")
public class SirketController {
    private ISirketService sirketService;
    @Autowired
    public SirketController(ISirketService sirketService) {
        this.sirketService = sirketService;
    }
    @GetMapping("/sirketler")
    public List<Sirket> get (){
        System.out.println(this.sirketService.getAll().size());
        return this.sirketService.getAll();

    }

    @PostMapping("/add")
    public void add(@RequestBody Sirket sirket){
        this.sirketService.add(sirket);
    }

    @PostMapping("/update")
    public void update(@RequestBody Sirket sirket){
        this.sirketService.update(sirket);

    }
    @PostMapping("/delete")
    public void delete(@RequestBody Sirket sirket){
        this.sirketService.delete(sirket);


    }
    @GetMapping("/sirketler/{id}")
    public Sirket getId (@PathVariable int id){
        System.out.println(this.sirketService.getAll().size());
        return this.sirketService.getById(id);

    }


}
