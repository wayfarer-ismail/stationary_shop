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
            URL url2 = new URL("https://cdn11.bigcommerce.com/s-r6vjsnlxmh/images/stencil/608x608/products/3978/3665/I1009-bottles__43908.1681938025__49525.1682023874.jpg");
            URL url3 = new URL("https://www.iguanasell.com/cdn/shop/products/S.T.-Dupont-Liberte-Rollerball-pen-Black-Lacquer-Palladium-trim-462674-04_5000x.jpg");
            URL url4 = new URL("https://i.etsystatic.com/11732535/r/il/69edd5/5459408892/il_1588xN.5459408892_dold.jpg");
            URL url5 = new URL("https://www.italianpens.com/canoABM/_files//PINEIDER/Alchemist%20Kilauea%20Blue/Screenshot%202022-06-08%20091443.jpg");
            URL url6 = new URL("https://m.media-amazon.com/images/I/71ND1hQXJ8L._AC_SL1500_.jpg");
            URL url7 = new URL("https://m.media-amazon.com/images/I/61zQl+3eBaL._AC_SL1500_.jpg");
            URL url8 = new URL("https://m.media-amazon.com/images/I/71jq8+X4e3L._AC_SL1500_.jpg");
            URL url9 = new URL("https://m.media-amazon.com/images/I/71fxZr53-OL._AC_SL1500_.jpg");
            URL url10 = new URL("https://m.media-amazon.com/images/I/71IuuqqX1gL._AC_SL1498_.jpg");

            byte[] image1 = readBytesFromUrl(url1);
            byte[] image2 = readBytesFromUrl(url2);
            byte[] image3 = readBytesFromUrl(url3);
            byte[] image4 = readBytesFromUrl(url4);
            byte[] image5 = readBytesFromUrl(url5);
            byte[] image6 = readBytesFromUrl(url6);
            byte[] image7 = readBytesFromUrl(url7);
            byte[] image8 = readBytesFromUrl(url8);
            byte[] image9 = readBytesFromUrl(url9);
            byte[] image10 = readBytesFromUrl(url10);

            CatalogueItem item1 = new CatalogueItem("Laban Taroko Rollerball Pen Marble Gorge", """
                    Laban Taroko Marble Gorge Rollerball Pen inspired by the Taroko National Park in Taiwan. Features a navy blue marbled effect acrylic resin barrel. Complemented by a gold-plated clip and gold-plated trim.
                    Classic cigarette shape pen. Made from acrylic resin, making this a lightweight and comfortable to hold, even for longer writing sessions.
                    Measures 145mm capped, 160mm posted and 127mm with the cap off. Weighs 26g.
                    Presented in a gift box.""", 115.0, image1);
            CatalogueItem item2 = new CatalogueItem("Colorverse Ink Set, Check & Shading Artist Edition", """
                    This limited edition set from Colorverse is a collaboration with Korean artist Yeonwoong Sung in celebration of the artist’s 10th solo exhibition “The Picnic.” The color choices are a homage to the artist's paintings, which use black-and-white check patterns and the play of light and shade.
                    Open the box to reveal a card that tells you more about the artist, as well as Colorverse’s classic constellation design. Both teardrop-shaped ink bottles are securely mounted in foam for extra protection. This set includes one 65mL bottle of Check, a basic black, and a 15mL bottle of Shading, a blue-gray complementary color.
                    Colorverse inks exhort you to "colorize your universe." They are carefully blended to conduct the ethereal beauty, wonder, and intense vitality of the universe to your pen. The inks are made with high-purity raw materials and their pH is optimized for a long shelf life. Perfect for fountain pen or dip pen use.""", 42.50, image2);
            CatalogueItem item3 = new CatalogueItem("S.T. Dupont Liberté Rollerball pen, Black Lacquer, Palladium trim, 462674", """
                    Trim - Palladium
                    Filling System - Original Refill
                    Closing System - Snap-on
                    Barrel length - 13.9 mm.
                    Warranty - 3 years
                    Country of Manufacture - France""", 484, image3);
            CatalogueItem item4 = new CatalogueItem("Maki-e Urushi Lacquer Makie Fountain Pen Yamanaka lacquer Crane Sunrise Japan", """
                    Origin : Made in Japan / Yamanaka lacquerware
                    Condition : Brand new
                    Ink : cartridge type (OHTO FCR-6 ink is used in this item so please use the same standard ink for replacement.)
                    Ink color : Black
                    Material: Aluminum (Urethan coating)
                    Nib : The Nib is steel(gold plated) finishing. It is made in Europe so it is fine internationally and it is middle fine in Japan.
                    Feed material : Resin
                    Clip : SK material (Carbon tool steel)
                    Crown/palette→Brass
                    Nib brand : SCHMIDT""", 123.0, image4);
            CatalogueItem item5 = new CatalogueItem("PINEIDER ALCHEMIST STROMBOLI BLACK FOUNTAIN PEN 14K NIB", """
                    The Pineider Alchemist Stromboli Black Fountain Pen 14k Nib is another brilliant innovation from Dante del Vecchio. Zeolites are minerals of volcanic origin that formed millions of years ago from the encounter of glowing lava and seawater. Today this alchemical transformation of magma occurs with every eruption, for example, in the Kilawea volcano in Hawaii or in the Italian Stromboli. Zeolite enters the pen world with The Alchemist where tactile feeling and impact resistance are key points for a good pen. The formula developed with over 40 % pure and low pressure printed Zeolite gives a velvety surface, a remarkable impact resistance, preserves the anionic and cationic properties of the material, a natural hydrophilia, perfect porosity and excellent grip for the hand.""", 640.0, image5);
            CatalogueItem item6 = new CatalogueItem("Online Campus Blue Hexagon Fountain Pen", """
                    Ergonomic writing: the soft-touch grip is ergonomically designed for a relaxed writing experience. Even in long-term use, there is no cramping with the Campus fountain pen.
                    Robust nib: the Iridium nib in line width M (medium). It is particularly stable and durable. The perfect pen for school, college and work in the office.
                    For students and professionals: the new Campus fountain pen model is equipped with a practical clip. This is made of pure stainless steel and is guaranteed nickel-free and therefore also suitable for allergy sufferers.
                    Standard cartridges: suitable for all standard ink cartridges. We recommend the online combination ink cartridges, a large capacity cartridge in royal blue is included""", 46.0, image6);
            CatalogueItem item7 = new CatalogueItem("Vandro Vintage Fountain Pen Set", "This Vandro Fountain Pen has a sleek red finish with a fine iridium nib for smooth writing. It's exceptional design adds a touch of modern class to your writing routine and leaves a lasting impression", 18.30, image7);
            CatalogueItem item8 = new CatalogueItem("Personalized Pens, Engraved Pen for Men", "These rollerball pens make a great personalized gift choice that will be treasured by your graduate. A surprise for your father, husband or brother. There can be engraved anything you desire, your name, monograms, or business information.", 11.0, image8);
            CatalogueItem item9 = new CatalogueItem("Wordsworth & Black Fountain Pen Set", "Elegant And Beauty, Made To Impress Everyone - Beautifully balanced metallic design adds a touch of modern class to your daily routine. It gives high precision and exceptional writing comfort for every occasion, coupled with a gorgeous design. Pulled directly from our Erudite Collection, we've combined the weight of superior metals perfectly weighted and balanced for a premium writing experience. This refillable modern fountain pen delivers refined style and an exceptionally smooth writing.", 30.0, image9);
            CatalogueItem item10 = new CatalogueItem("QAQcew Fidget Pen, Decompression Magnetic Fidget Toy Pen", "This magnetic pen is not only a writing pen, but also a cool toy pen with finger magnet gadget. The magnet pen has created countless interesting, imaginative and creative sculptures, shapes, patterns and puzzles.", 16.50, image10);

            catalogueService.save(item1);
            catalogueService.save(item2);
            catalogueService.save(item3);
            catalogueService.save(item4);
            catalogueService.save(item5);
            catalogueService.save(item6);
            catalogueService.save(item7);
            catalogueService.save(item8);
            catalogueService.save(item9);
            catalogueService.save(item10);
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