package org.elbahja.stationery_shop;

import org.elbahja.stationery_shop.model.CatalogueItem;
import org.elbahja.stationery_shop.model.UserRequest;
import org.elbahja.stationery_shop.service.CatalogueService;
import org.elbahja.stationery_shop.service.UserDetailsServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CatalogueService catalogueService;
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    public DataLoader(CatalogueService catalogueService, UserDetailsServiceImpl userDetailsServiceImpl) {
        this.catalogueService = catalogueService;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCatalogueItems();
        loadDefaultAdmin();
    }

    private void loadDefaultAdmin() {
        UserRequest admin = new UserRequest("admin", "admin");
        if(!userDetailsServiceImpl.userExists (admin.username())) {
            userDetailsServiceImpl.registerUser(admin);
        }
    }

    private void loadCatalogueItems() {
        CatalogueItem item1 = new CatalogueItem("Item 1", "Description 1", 10.0, "/images/image1.png");
        CatalogueItem item2 = new CatalogueItem("Item 2", "Description 2", 20.0, "/images/image2.png");
        CatalogueItem item3 = new CatalogueItem("Item 3", "Description 3", 30.0, "/images/image3.png");
        catalogueService.save(item1);
        catalogueService.save(item2);
        catalogueService.save(item3);
    }
}