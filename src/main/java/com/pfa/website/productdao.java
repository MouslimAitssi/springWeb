package com.pfa.website;

import java.util.List;

public interface productdao {

    public List<product> findAll();
    public product findbyid(int id);
    public product save();
}
