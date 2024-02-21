package org.elbahja.stationery_shop.controller;

import org.elbahja.stationery_shop.service.CatalogueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController {
    CatalogueService catalogueService;

    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @GetMapping
    public String getCatalogue(Model model) {
        model.addAttribute("catalogue", catalogueService.getCatalogue());
        return "catalogue";
    }
}
