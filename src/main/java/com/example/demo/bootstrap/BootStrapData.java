package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;


/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final InhousePartRepository inhousePartRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (partRepository.count() == 0 && productRepository.count() == 0) {

            InhousePart lettuce = new InhousePart("lettuce", 5, 15, 5, 25);
            InhousePart cheese = new InhousePart("cheese", 5, 15, 5, 25);
            InhousePart mayo = new InhousePart("mayo", 5, 15, 5, 25);
            OutsourcedPart salami = new OutsourcedPart("salami", 5, 15, 5, 25, "Meat Market");
            OutsourcedPart pastrami = new OutsourcedPart("pastrami", 5, 15, 5, 25, "Meat Market");

            partRepository.save(lettuce);
            partRepository.save(cheese);
            partRepository.save(mayo);
            partRepository.save(salami);
            partRepository.save(pastrami);

            Product salamiSandwich = new Product("salami sandwich", 20, 15);
            Product pastramiSandwich = new Product("pastrami sandwich", 20, 15);
            Product bolognaSandwich = new Product("bologna sandwich", 20, 15);
            Product turkeySandwich = new Product("turkey sandwich", 20, 15);
            Product chickenSandwich = new Product("chicken sandwich", 20, 15);




            productRepository.save(salamiSandwich);
            productRepository.save(pastramiSandwich);
            productRepository.save(bolognaSandwich);
            productRepository.save(turkeySandwich);
            productRepository.save(chickenSandwich);

            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

            System.out.println("Inventory successfully added.");
        } else {

            System.out.println("Inventory already exists!");
        }
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products" + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts" + partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
