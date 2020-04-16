package com.spring.website;

import java.util.List;

public interface productdao {

    public List<product> findAll();
    public product findbyId(int id);
    public product save(product game);
}
