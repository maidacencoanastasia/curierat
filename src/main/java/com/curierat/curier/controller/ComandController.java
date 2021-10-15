package com.curierat.curier.controller;

import com.curierat.curier.model.Comanda;
import com.curierat.curier.model.Status;
import com.curierat.curier.repository.ComandRepositoriu;
import com.curierat.curier.repository.StatusRepositoriu;
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
    private StatusRepositoriu statusRepositoriu;

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
//        Status status = statusRepositoriu.findById(id).orElseThrow();
        model.addAttribute("comanda", comanda);
//        model.addAttribute("status",status);
        return "comanda";
    }

    @GetMapping("/status/{id}/add")
    public String updateStatus(@PathVariable(value = "id") Integer id, Model model) {
        Status status = statusRepositoriu.findById(id).orElseThrow();
        return "update";
    }
}
