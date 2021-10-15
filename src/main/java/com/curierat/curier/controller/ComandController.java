package com.curierat.curier.controller;

import com.curierat.curier.model.Comanda;
import com.curierat.curier.repository.ComandRepositoriu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("comenzi")
public class ComandController {
    private ComandRepositoriu comandRepositoriu;

    @Autowired
    public ComandController(ComandRepositoriu comandRepositoriu) {
        this.comandRepositoriu = comandRepositoriu;
    }

    @GetMapping("")
    public String getComanda(Model model) {
        return "comenzi";
    }

    @Transactional(readOnly = true)
    @GetMapping("/comanda/{id}")
    public String getComanda(@PathVariable int id, Model model) {
        Comanda comanda = comandRepositoriu.findById(id).get();
        model.addAttribute("comanda", comanda);
        return "comanda";
    }
}
