package com.pfa.website;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
        product game = dao.findbyId(id);


        return game;
    }

}
