package com.digiadvert.ReklamOtomasyon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/123")
public class test {
    @GetMapping
    public String get(){
        return "deneme";


    }


}
