package com.digiadvert.ReklamOtomasyon.RestApi;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Reklamlar;
import com.digiadvert.ReklamOtomasyon.Service.IReklamlarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reklam")
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

    @PostMapping("/add")
    public void add(@RequestBody Reklamlar reklamlar){
        this.reklamlarService.add(reklamlar);
    }

    @PostMapping("/update")
    public void update(@RequestBody Reklamlar reklamlar){
        this.reklamlarService.add(reklamlar);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Reklamlar reklamlar){
        this.reklamlarService.add(reklamlar);
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
    public Reklamlar getCliAdvState(@RequestParam String reklamNo){
        //müşterinin bir reklamı getirilir Zaten bir tane reklam verebiliyor gibi gözüküyor :))))
        return this.reklamlarService.getMusteriReklamState(reklamNo);
    }


}
