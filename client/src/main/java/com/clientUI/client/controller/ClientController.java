package com.clientUI.client.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ClientController {
    public String accueil(Model model) {
        return "Accueil";
    }
}
