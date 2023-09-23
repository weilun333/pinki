package com.cw.pinki.brand.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/prod")
public class ProdInfoController {
    @GetMapping ("/category")
    public  void setProdCategory(){

    }

    @PostMapping("/pic")
    public void addProdPic(){

    }

    @PostMapping("/info")
    public void addProd(){

    }

}
