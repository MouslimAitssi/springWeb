package com.spring.website;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productcontroller {


    @Autowired
    private productdao dao;

    @GetMapping(value="produits")
    public List<product> listeProduits() {
        return dao.findAll();

    }

    @GetMapping(value="produits/{id}")
    public product afficherProduit(@PathVariable int id) {
        return dao.findbyId(id);
    }

    @PostMapping(value="produits")
    public void ajouterProduit(@RequestBody product game) {
        dao.save(game);
    }
}
