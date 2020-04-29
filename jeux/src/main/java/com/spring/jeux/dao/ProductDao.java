package com.spring.jeux.dao;

import com.spring.jeux.model.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Jeu, Integer> {

/* Documentation:
https://docs.spring.io/spring-data/data-jpa/docs/1.1.x/reference/html/#jpa.query-methods.query-creation
test db:
jdbc:h2:mem:testdb
 */
    Jeu findById(int id);

    /*@Query("select id, nom, prix from Jeu p where p.prix = max(p.prix)")
    Jeu findMaxPrice();*/
}
