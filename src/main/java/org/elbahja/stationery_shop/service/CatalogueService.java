package org.elbahja.stationery_shop.service;

import org.elbahja.stationery_shop.model.CatalogueItem;
import org.elbahja.stationery_shop.repository.CatalogueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService {
    CatalogueRepository catalogueRepository;

    public CatalogueService(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public List<CatalogueItem> getCatalogue() {
        return catalogueRepository.findAll();
    }

    public void save(CatalogueItem item) {
        catalogueRepository.save(item);
    }
}
