package com.spring.website;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Void> ajouterProduit(@RequestBody product game) {

        product result = dao.save(game);
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
