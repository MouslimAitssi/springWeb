package com.spring.jeux.controller;


import com.spring.jeux.exceptions.JeuIntrouvableException;
import com.spring.jeux.model.Jeu;
import com.spring.jeux.dao.JeuDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;


@Api(description = "Gestion des jeux qu'on a")
@RestController
public class JeuController {


    @Autowired
    private JeuDao dao;

    @ApiOperation(value = "Affiche tous les jeux qu'on possède")
    @GetMapping(value="produits")
    public List<Jeu> listeProduits() {

        List<Jeu> jeux = dao.findAll();

        if(jeux.isEmpty()) {
            try {
                throw new JeuIntrouvableException("Ouups, aucun jeu n'est disponible.");
            } catch (JeuIntrouvableException e) {
                e.printStackTrace();
            }
        }
        return jeux;
    }

    @ApiOperation(value = "Récupère un jeu à travers son ID")
    @GetMapping(value="produits/{id}")
    public Jeu afficherProduit(@PathVariable int id) throws JeuIntrouvableException{
        Jeu game = dao.findById(id);
        if(game==null) {

                throw new JeuIntrouvableException("Le produit avec l'id "+ id + " est introuvable");

        }
        return game;
    }

    @ApiOperation(value = "Ajoute le jeu reçu dans le body de la requête")
    @PostMapping(value="produits")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Jeu game) {

        Jeu result = dao.save(game);

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