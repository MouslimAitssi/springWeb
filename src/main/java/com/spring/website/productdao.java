package com.spring.website;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productdao extends JpaRepository<product, Integer> {

    product findById(int id);
}
