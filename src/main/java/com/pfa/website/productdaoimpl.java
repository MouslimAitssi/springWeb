package com.pfa.website;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class productdaoimpl implements  productdao{

    public static ArrayList<product> products = new ArrayList<>();
    static {
        products.add(new product(1, "television", 5000));
        products.add(new product(2, "telephone", 9000));
        products.add(new product(3, "table de ping pong", 1000));
    }

    @Override
    public List<product> findAll() {
        return products;
    }

    @Override
    public product findbyid(int id) {
        return null;
    }

    @Override
    public product save() {
        return null;
    }
}
