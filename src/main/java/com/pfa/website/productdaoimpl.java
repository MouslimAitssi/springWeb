package com.pfa.website;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class productdaoimpl implements  productdao{

    public static ArrayList<product> products = new ArrayList<>();
    static {

        products.add(new product(1, "Cyberpunk 2077", 2000));
        products.add(new product(2, "Ghost of Tsushima", 1000));
        products.add(new product(3, "Axiom Verge 2", 5000));
        products.add(new product(4, "Resident Evil 3", 1000));
        products.add(new product(5, "Sports Story", 1500));
        products.add(new product(6, "GTA VI", 2000));
    }

    @Override
    public List<product> findAll() {
        return products;
    }

    @Override
    public product findbyId(int id) {
        for (product game : products) {
            if(game.getId() ==id){
                return game;
            }
        }
        return null;


    }

    @Override
    public product save(product game) {

        products.add(game);
        return game;
    }
}
