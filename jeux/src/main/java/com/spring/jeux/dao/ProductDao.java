package com.spring.jeux.dao;

import com.spring.jeux.model.Product;
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

    /*@Query("select id, nom, prix from Product p where p.prix = max(p.prix)")
    Product findMaxPrice();*/
}
