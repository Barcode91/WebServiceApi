package com.digiadvert.ReklamOtomasyon.RestApi;

import com.digiadvert.ReklamOtomasyon.HibernateEntities.Pano;
import com.digiadvert.ReklamOtomasyon.Service.IPanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pano")
@CrossOrigin(origins = "http://localhost:4200")
public class PanoController {
    private IPanoService panoService;
    @Autowired
    public PanoController(IPanoService panoService) {
        this.panoService = panoService;
    }
    @GetMapping("/panolar")
    public List<Pano> get(){
        return this.panoService.getAll();

    }
    @PostMapping("/add")
    public void add(@RequestBody Pano pano){
        this.panoService.add(pano);
    }

    @PostMapping("/update")
    public void update(@RequestBody Pano pano){
        this.panoService.update(pano);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Pano pano){
        this.panoService.delete(pano);
    }

    @GetMapping("/{id}")
    public Pano getById(@PathVariable int id){
        return this.panoService.getById(id);

    }

    @PostMapping("/durumlar") // json verisi ile istek atılır
    public List<Pano> getState(@RequestBody Map<String,String> value){
        return this.panoService.getAdvState(value.get("panoNo"),value.get("durum"));
    }


    @GetMapping("/durumlar") //localhost:8082/api/pano/durumlar/?state=a
    public List<Pano> getState(@RequestParam String state){
        return this.panoService.getPanoState(state);


    }



}
