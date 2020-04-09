package com.pfa.website;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class productcontroller {

    productdao dao;

    @GetMapping(value="/porduits")
    public List<product> listeProduits() {
        return dao.findAll();

    }

    @GetMapping(value="produits/{id}")
    public product afficherProduit(@PathVariable int id) {
        product produit = new product(id, "PC Gamer", 20000);
        return produit;
    }

}
