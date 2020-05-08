package com.clientUI.clientui.proxies;

import com.clientUI.clientui.beans.JeuBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "jeux", url="localhost:9000")
public interface JeuxProxy {
    @GetMapping(value="produits")
    List<JeuBean> listeProduits();

    @GetMapping(value="produits/{id}")
    JeuBean afficherProduit(@PathVariable("id") int id);

}