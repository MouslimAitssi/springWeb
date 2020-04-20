package com.spring.website.controller;


import com.spring.website.exceptions.ProduitIntrouvableException;
import com.spring.website.model.Product;
import com.spring.website.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductDao dao;

    @GetMapping(value="produits")
    public List<Product> listeProduits() {
        return dao.findAll();
    }

    @GetMapping(value="produits/{id}")
    public Product afficherProduit(@PathVariable int id) throws ProduitIntrouvableException {
        Product game = dao.findById(id);
        if(game == null) {
            throw new ProduitIntrouvableException("Le produit avec l'id "+ id + "n'existe pas.");
        }
        return game;
    }

    @GetMapping(value="produits/gt/{prix}")
    public List<Product> plusCherQue(@PathVariable int prix) {return dao.findByPrixGreaterThan(prix);}

    @GetMapping(value="produits/lt/{prix}")
    public List<Product> moinsCherQue(@PathVariable int prix) {return dao.findByPrixLessThan(prix);}

    /*@GetMapping(value="produits/max")
    public Product plusChere() {return dao.findMaxPrice();}*/

    @PostMapping(value="produits")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Product game) {
        
        Product result = dao.save((Product)game);
        System.out.println(game);
        if(result == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.getId())
                .toUri();

         return ResponseEntity.created(location).build();
    }
}