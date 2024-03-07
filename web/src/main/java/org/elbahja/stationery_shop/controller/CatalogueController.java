package org.elbahja.stationery_shop.controller;

import org.elbahja.stationery_shop.model.CatalogueItem;
import org.elbahja.stationery_shop.service.CatalogueService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public String getItem(Model model, @PathVariable Long id) {
        model.addAttribute("item", catalogueService.getItem(id));
        return "item";
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadImage(@PathVariable Long id) {
        CatalogueItem item = catalogueService.findById(id).orElseThrow();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + item.getName() + "\"")
                .body(new ByteArrayResource(item.getImage()));
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] imageBytes = file.getBytes();
        CatalogueItem item = new CatalogueItem("name", "description", 10.0, imageBytes);
        catalogueService.save(item);
    }
}
