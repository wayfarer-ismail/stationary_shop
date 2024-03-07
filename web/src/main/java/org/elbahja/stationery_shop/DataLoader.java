package org.elbahja.stationery_shop;

import org.elbahja.stationery_shop.model.CatalogueItem;
import org.elbahja.stationery_shop.model.UserRequest;
import org.elbahja.stationery_shop.service.CatalogueService;
import org.elbahja.stationery_shop.service.UserDetailsServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

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
        try {
            URL url1 = new URL("https://cultpens.com/cdn/shop/products/LB83715_Laban-Taroko-Rollerball-Pen-Marble-Gorge_P1_720x@2x.jpg");
            URL url2 = new URL("https://cultpens.com/cdn/shop/products/LB83715_Laban-Taroko-Rollerball-Pen-Marble-Gorge_P1_720x@2x.jpg");
            URL url3 = new URL("https://cultpens.com/cdn/shop/products/LB83715_Laban-Taroko-Rollerball-Pen-Marble-Gorge_P1_720x@2x.jpg");

            byte[] image1 = readBytesFromUrl(url1);
            byte[] image2 = readBytesFromUrl(url2);
            byte[] image3 = readBytesFromUrl(url3);

            CatalogueItem item1 = new CatalogueItem("Item 1", "Description 1", 10.0, image1);
            CatalogueItem item2 = new CatalogueItem("Item 2", "Description 2", 20.0, image2);
            CatalogueItem item3 = new CatalogueItem("Item 3", "Description 3", 30.0, image3);

            catalogueService.save(item1);
            catalogueService.save(item2);
            catalogueService.save(item3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] readBytesFromUrl(URL url) throws IOException {
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            while (rbc.read(buffer) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    out.write(buffer.get());
                }
                buffer.clear();
            }
            return out.toByteArray();
        }
    }
}