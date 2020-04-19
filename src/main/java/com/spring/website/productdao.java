package com.spring.website;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productdao extends JpaRepository<product, Integer> {

/* Documentation:
https://docs.spring.io/spring-data/data-jpa/docs/1.1.x/reference/html/#jpa.query-methods.query-creation
test db:
jdbc:h2:mem:testdb
 */
    product findById(int id);
    List<product> findByPrixGreaterThan(int prixLimit);
    List<product> findByPrixLessThan(int prixLimit);

    /*@Query("select id, nom, prix from product p where p.prix = max(p.prix)")
    product findMaxPrice();*/
}
