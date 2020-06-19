package com.clientUI.clientui.controller;

import com.clientUI.clientui.beans.JeuBean;
import com.clientUI.clientui.proxies.JeuxProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class ClientController {

    @Autowired
    JeuxProxy proxy;

    @RequestMapping("/")
    public String accueil(Model model) {

        List<JeuBean> produits = proxy.listeProduits();

        model.addAttribute("produits", produits);

        return "Accueil.xhtml";
    }

}