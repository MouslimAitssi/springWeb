package com.spring.website.dao;

import com.spring.website.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

/* Documentation:
https://docs.spring.io/spring-data/data-jpa/docs/1.1.x/reference/html/#jpa.query-methods.query-creation
test db:
jdbc:h2:mem:testdb
 */
    Product findById(int id);
    List<Product> findByPrixGreaterThan(int prixLimit);
    List<Product> findByPrixLessThan(int prixLimit);

    /*@Query("select id, nom, prix from Product p where p.prix = max(p.prix)")
    Product findMaxPrice();*/
}